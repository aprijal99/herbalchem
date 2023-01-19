package org.herbal.chem.structure.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
    @Value("${kafka.structure.service.topic}")
    private String structureServiceTopic;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(structureServiceTopic)
                .partitions(5)
                .build();
    }
}
