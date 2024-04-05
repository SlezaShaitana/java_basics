package com.example.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = SpringApplication.run(SpringBootApp.class, args);
    }
}