package org.herbal.chem.compound;

import org.herbal.chem.compound.entity.CompoundEntity;
import org.herbal.chem.compound.service.CompoundService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan("org.herbal.chem")
public class CompoundServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompoundServiceApplication.class);
    }
}
