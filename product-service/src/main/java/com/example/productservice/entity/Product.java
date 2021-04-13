package com.example.productservice.entity;

import lombok.Data;


@Data
public class Product {
    private Long id;
    private String uniqId;
    private String sku;
    private String name_title;
    private String description;
    private double listPrice;
    private double salePrice;
    private String category;
    private String categoryTree;
    private String averageProductRating;
    private String productUrl;
    private String productImageUrls;
    private String brand;
    private String totalNumberReviews;
    private String reviews;
}

