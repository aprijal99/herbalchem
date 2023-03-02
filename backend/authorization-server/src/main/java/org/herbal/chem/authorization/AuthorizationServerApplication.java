package org.herbal.chem.authorization;

import org.herbal.chem.authorization.entity.UserAccountEntity;
import org.herbal.chem.authorization.service.UserAccountService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthorizationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class);
    }

    @Bean
    public ApplicationRunner runner(
            UserAccountService userAccountService
    ) {
        return args -> {
            userAccountService.saveUserAccount(
                    UserAccountEntity.builder()
                            .name("Admin")
                            .username("admin")
                            .email("admin@herbalchem.site")
                            .password("password")
                            .role("ADMIN")
                            .build()
            );
        };
    }
}
