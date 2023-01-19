package org.herbal.chem.compound.form.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.herbal.chem.api.dto.KafkaReply;
import org.herbal.chem.api.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class CompoundFormServiceImpl implements CompoundFormService {
    @Value("${kafka.compound.service.topic.request-topic}")
    private String compoundServiceRequestTopic;
    @Value("${kafka.compound.service.topic.reply-topic}")
    private String compoundServiceReplyTopic;

    private final ReplyingKafkaTemplate<String, byte[], KafkaReply> replyingKafkaTemplate;

    private final StreamBridge streamBridge;

    public CompoundFormServiceImpl(ReplyingKafkaTemplate<String, byte[], KafkaReply> replyingKafkaTemplate, StreamBridge streamBridge) {
        this.replyingKafkaTemplate = replyingKafkaTemplate;
        this.streamBridge = streamBridge;
    }

    public Integer sendCompoundServiceDtoToKafka(byte[] serializedCompoundServiceDto) {
        ProducerRecord<String, byte[]> producerRecord = new ProducerRecord<>(compoundServiceRequestTopic, "", serializedCompoundServiceDto);
        producerRecord.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, compoundServiceReplyTopic.getBytes(StandardCharsets.UTF_8)));

        RequestReplyFuture<String, byte[], KafkaReply> replyFuture = replyingKafkaTemplate.sendAndReceive(producerRecord, Duration.ofSeconds(10));
        ConsumerRecord<String, KafkaReply> consumerRecord = null;

        try {
            SendResult<String, byte[]> sendResult = replyFuture.getSendFuture().get(10, TimeUnit.SECONDS);
            log.info("Sent OK to {}", sendResult.getRecordMetadata());

            consumerRecord = replyFuture.get(10, TimeUnit.SECONDS);
            log.info("Returned value is {}", consumerRecord.value().toString());
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new ServerErrorException(e.getMessage(), e.getCause());
        }

        int statusCode = consumerRecord.value().getStatus().value();

        if (HttpStatus.valueOf(statusCode).is2xxSuccessful()) {
            return (Integer) consumerRecord.value().getData().get("herbalChemCid");
        } else if (HttpStatus.valueOf(statusCode).is4xxClientError()) {
            throw new InvalidInputException(consumerRecord.value().getMessage());
        } else {
            return null;
        }
    }

    public void sendCompoundDetailRequestToKafka(byte[] serializedCompoundDetailRequest) {
        streamBridge.send("compoundDetailRequestProducer-out-0", serializedCompoundDetailRequest);
    }
}
