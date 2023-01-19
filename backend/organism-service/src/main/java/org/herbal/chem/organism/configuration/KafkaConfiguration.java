package org.herbal.chem.organism.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
    @Value("${kafka.organism.service.topic}")
    private String organismServiceTopic;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(organismServiceTopic)
                .partitions(5)
                .build();
    }
}
