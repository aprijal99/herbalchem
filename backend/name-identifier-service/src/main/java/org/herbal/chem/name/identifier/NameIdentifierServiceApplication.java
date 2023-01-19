package org.herbal.chem.name.identifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NameIdentifierServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NameIdentifierServiceApplication.class);
    }
}
