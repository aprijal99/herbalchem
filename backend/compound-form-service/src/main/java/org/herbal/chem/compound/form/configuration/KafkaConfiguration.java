package org.herbal.chem.compound.form.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.herbal.chem.api.dto.KafkaReply;
import org.herbal.chem.api.dto.converter.KafkaReplyDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServer;
    @Value("${kafka.reply.consumer-group}")
    private String consumerGroup;
    @Value("${kafka.compound.service.topic.request-topic}")
    private String compoundServiceRequestTopic;
    @Value("${kafka.compound.service.topic.reply-topic}")
    private String compoundServiceReplyTopic;
    @Value("${kafka.compound.detail.request.topic}")
    private String compoundDetailRequestTopic;
    @Value("${kafka.name.identifier.service.topic}")
    private String nameIdentifierServiceTopic;
    @Value("${kafka.chemical.physical.property.service.topic}")
    private String chemicalPhysicalPropertyServiceTopic;
    @Value("${kafka.organism.service.topic}")
    private String organismServiceTopic;
    @Value("${kafka.structure.service.topic}")
    private String structureServiceTopic;

    @Bean
    public ProducerFactory<String, byte[]> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public ConsumerFactory<String, KafkaReply> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new KafkaReplyDeserializer()
        );
    }

    @Bean
    public KafkaTemplate<String, byte[]> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, KafkaReply> replyContainer(
            ConcurrentKafkaListenerContainerFactory<String, KafkaReply> factory
    ) {
        factory.setConsumerFactory(consumerFactory());
        factory.setReplyTemplate(kafkaTemplate());

        ConcurrentMessageListenerContainer<String, KafkaReply> repliesContainer =
                factory.createContainer(compoundServiceReplyTopic);
        repliesContainer.setAutoStartup(false);

        return repliesContainer;
    }

    @Bean
    public ReplyingKafkaTemplate<String, byte[], KafkaReply> replyingKafkaTemplate(
            ProducerFactory<String, byte[]> pf,
            ConcurrentMessageListenerContainer<String, KafkaReply> replyContainer
    ) {
        return new ReplyingKafkaTemplate<>(pf, replyContainer);
    }

    @Bean
    public KafkaAdmin.NewTopics newTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(compoundServiceRequestTopic).partitions(5).build(),
                TopicBuilder.name(compoundServiceReplyTopic).partitions(5).build(),
                TopicBuilder.name(compoundDetailRequestTopic).partitions(5).build(),
                TopicBuilder.name(nameIdentifierServiceTopic).partitions(5).build(),
                TopicBuilder.name(chemicalPhysicalPropertyServiceTopic).partitions(5).build(),
                TopicBuilder.name(organismServiceTopic).partitions(5).build(),
                TopicBuilder.name(structureServiceTopic).partitions(5).build()
        );
    }
}
