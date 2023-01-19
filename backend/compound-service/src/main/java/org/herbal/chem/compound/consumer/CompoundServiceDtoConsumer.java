package org.herbal.chem.compound.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.api.dto.KafkaReply;
import org.herbal.chem.compound.entity.CompoundEntity;
import org.herbal.chem.compound.mapper.CompoundMapper;
import org.herbal.chem.compound.service.CompoundService;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.SerializationUtils;

import java.util.Map;

@Slf4j
@Configuration
@AllArgsConstructor
public class CompoundServiceDtoConsumer {
    private final CompoundService compoundService;
    private final CompoundMapper compoundMapper;

    @KafkaListener(
            topics = {"${kafka.compound.service.topic.request-topic}"},
            groupId = "${kafka.compound.service.consumer-group}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public Message<KafkaReply> listen(
            ConsumerRecord<String, byte[]> in,
            @Header(KafkaHeaders.REPLY_TOPIC) byte[] replyTopic,
            @Header(KafkaHeaders.CORRELATION_ID) byte[] correlationId
    ) {
        CompoundServiceDto compoundServiceDto = (CompoundServiceDto) SerializationUtils.deserialize(in.value());
        CompoundEntity compoundEntity = compoundMapper.dtoToEntity(compoundServiceDto);

        KafkaReply kafkaReply = null;

        try {
            CompoundEntity savedCompound = compoundService.saveCompound(compoundEntity);
            Integer herbalChemCid = savedCompound.getHerbalChemCid();

            kafkaReply = new KafkaReply(
                    HttpStatus.CREATED,
                    "The compound has been stored to the database with cid: " + herbalChemCid,
                    Map.of("herbalChemCid", herbalChemCid)
            );
        } catch (DataAccessException e) {
            log.error(e.getMessage());

            kafkaReply = new KafkaReply(HttpStatus.CONFLICT, e.getMessage(), null);
        }

        return MessageBuilder
                .withPayload(kafkaReply)
                .setHeader(KafkaHeaders.TOPIC, replyTopic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "ReturnValue")
                .setHeader(KafkaHeaders.CORRELATION_ID, correlationId)
                .build();
    }
}
