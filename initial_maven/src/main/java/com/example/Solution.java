package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

import com.example.config.ApplicationProperties;

@SpringBootApplication
@ImportResource("applicationContext.xml")
@EnableConfigurationProperties({ ApplicationProperties.class })
public class Solution {

    public static void main(String[] args) {
        SpringApplication.run(Solution.class, args);
    }
}