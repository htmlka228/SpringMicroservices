package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/catalogServiceFallBack")
    public String catalogServiceFallBackMethod(){
        return "Catalog Service is taking longer than expected." +
                " Please try again later";
    }

    @GetMapping("/inventoryServiceFallBack")
    public String inventoryServiceFallBackMethod(){
        return "Inventory Service is taking longer than expected." +
                " Please try again later";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBackMethod(){
        return "Product Service is taking longer than expected." +
                " Please try again later";
    }
}
