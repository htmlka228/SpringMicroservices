package com.example.demoinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoInventoryApplication.class, args);
    }

}
