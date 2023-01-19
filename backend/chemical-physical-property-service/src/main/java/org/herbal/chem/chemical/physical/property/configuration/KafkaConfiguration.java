package org.herbal.chem.chemical.physical.property.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
    @Value("${kafka.chemical.physical.property.service.topic}")
    private String chemicalPhysicalPropertyServiceTopic;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(chemicalPhysicalPropertyServiceTopic)
                .partitions(5)
                .build();
    }
}
