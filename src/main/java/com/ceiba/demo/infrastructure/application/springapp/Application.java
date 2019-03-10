package com.ceiba.demo.infrastructure.application.springapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = "com.ceiba.demo")
@EnableJpaRepositories(basePackages = "com.ceiba.demo")
@ComponentScan(value = {"com.ceiba.demo"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
