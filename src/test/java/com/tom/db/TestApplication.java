package com.tom.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.tom.db.service.provider"
})

@Import({
        com.tom.db.beanServiceConfig.ServiceAccessConfig.class
})

@EnableJpaRepositories(basePackages = {
        "com.tom.db.repository"
})

@EntityScan(basePackages = {
        "com.tom.db.entity"					// @tom-db-entity
})

public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
