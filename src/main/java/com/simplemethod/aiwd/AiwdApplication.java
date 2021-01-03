package com.simplemethod.aiwd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories
public class AiwdApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AiwdApplication.class, args);
    }
}
