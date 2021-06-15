package com.example.productservice.entity;

import lombok.Data;

@Data
public class ProductAvailable {
    private String uniqId;
    private Integer availableQuantity = 0;
}
