package com.wakefit.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.wakefit.ecommerce")
@EnableJpaRepositories("com.wakefit.ecommerce.repository")
public class wakefitfurnitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(wakefitfurnitureApplication.class, args);
    }
}
