package com.example.productservice.controller;

import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productClients")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<?> getProducts(){
        return productService.getProduct();
    }

    @GetMapping("/{sku}")
    public List<?> getProductsBySku(@PathVariable String sku){
        return productService.getProductBySku(sku);
    }
}
