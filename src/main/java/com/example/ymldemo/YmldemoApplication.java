package com.example.ymldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class YmldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmldemoApplication.class, args);
    }

}
