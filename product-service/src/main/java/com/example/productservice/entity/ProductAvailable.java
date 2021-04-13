package com.example.productservice.entity;

import lombok.Data;

@Data
public class ProductAvailable {
    private String uniq_id;
    private Integer availableQuantity = 0;
}
