package com.example.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootApp.class, args);
    }
}