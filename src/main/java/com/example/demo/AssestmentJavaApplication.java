package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("it.unikey.DAL")
@EnableJpaRepositories("it.unikey.DAL")
public class AssestmentJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssestmentJavaApplication.class, args);
    }

}
