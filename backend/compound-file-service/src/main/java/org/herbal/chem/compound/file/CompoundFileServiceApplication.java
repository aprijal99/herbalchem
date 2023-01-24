package org.herbal.chem.compound.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CompoundFileServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompoundFileServiceApplication.class);
    }
}
