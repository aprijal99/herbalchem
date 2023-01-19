package org.herbal.chem.name.identifier.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
    @Value("${kafka.name.identifier.service.topic}")
    private String nameIdentifierServiceTopic;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(nameIdentifierServiceTopic)
                .partitions(5)
                .build();
    }
}
