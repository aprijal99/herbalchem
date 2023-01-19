package org.herbal.chem.compound.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.herbal.chem")
public class CompoundFormServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompoundFormServiceApplication.class);
    }
}
