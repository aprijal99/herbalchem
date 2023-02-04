package org.herbal.chem.compound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

//@EnableEurekaClient
@SpringBootApplication
@ComponentScan("org.herbal.chem")
public class CompoundServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompoundServiceApplication.class);
    }
}
