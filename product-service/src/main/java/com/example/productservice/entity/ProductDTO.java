package com.example.productservice.entity;

import lombok.Data;

@Data
public class ProductDTO {
    public ProductDTO(Product product, Integer availableQuantity){
        this.id = product.getId();
        this.uniqId = product.getUniqId();
        this.sku = product.getSku();
        this.name_title = product.getName_title();
        this.description = product.getDescription();
        this.listPrice = product.getListPrice();
        this.salePrice = product.getSalePrice();
        this.category = product.getCategory();
        this.categoryTree = product.getCategoryTree();
        this.averageProductRating = product.getAverageProductRating();
        this.productUrl = product.getProductUrl();
        this.productImageUrls = product.getProductImageUrls();
        this.brand = product.getBrand();
        this.totalNumberReviews = product.getTotalNumberReviews();
        this.reviews = product.getReviews();
        this.availableQuantity = availableQuantity;
    }
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
    private Integer availableQuantity;
}
