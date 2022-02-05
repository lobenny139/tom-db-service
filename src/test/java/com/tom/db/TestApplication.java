package com.tom.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        //local
        "com.tom.db.service.provider",
        //tom-redis-service
        "com.tom.cache.service.provider"
})

@Import({
        //local
        com.tom.db.beanServiceConfig.ServiceAccessConfig.class,
        //tom-redis-service
        com.tom.redis.beanServiceConfig.ServiceAccessConfig.class
})

@EnableJpaRepositories(basePackages = {
        //local
        "com.tom.db.repository"
})

@EntityScan(basePackages = {
        // @tom-db-entity
        "com.tom.db.entity"
})

public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
