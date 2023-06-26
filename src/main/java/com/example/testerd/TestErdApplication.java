package com.example.testerd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestErdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestErdApplication.class, args);
    }

}
