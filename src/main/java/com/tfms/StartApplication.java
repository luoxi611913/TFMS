package com.tfms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.tfms.dao")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class);
    }
}
