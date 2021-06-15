package com.example.demomicro.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uniq_id")
    private String uniqId;

    private String sku;
    private String name_title;
    private String description;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "sale_price")
    private double salePrice;

    private String category;

    @Column(name = "category_tree")
    private String categoryTree;

    @Column(name = "average_product_rating")
    private String averageProductRating;

    @Column(name = "product_url")
    private String productUrl;

    @Column(name = "product_image_urls")
    private String productImageUrls;

    private String brand;

    @Column(name = "total_number_reviews")
    private String totalNumberReviews;

    private String reviews;
}
