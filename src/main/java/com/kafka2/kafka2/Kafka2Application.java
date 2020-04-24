package com.kafka2.kafka2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
@MapperScan(basePackages = {"com.kafka2.kafka2.dao"})
public class Kafka2Application {
    public static void main(String[] args) {
        SpringApplication.run(Kafka2Application.class, args);
    }

}
