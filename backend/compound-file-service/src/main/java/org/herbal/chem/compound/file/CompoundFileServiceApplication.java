package org.herbal.chem.compound.file;

import org.herbal.chem.compound.file.configuration.RequestWrapperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

//@EnableEurekaClient
@SpringBootApplication
public class CompoundFileServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompoundFileServiceApplication.class);
    }

    @Bean
    public FilterRegistrationBean<RequestWrapperFilter> filterRegistrationBean() {
        FilterRegistrationBean<RequestWrapperFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new RequestWrapperFilter());
        filterFilterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return filterFilterRegistrationBean;
    }
}
