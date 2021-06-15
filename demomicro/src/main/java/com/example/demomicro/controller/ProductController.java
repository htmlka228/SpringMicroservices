package com.example.demomicro.controller;

import com.example.demomicro.entity.Product;
import com.example.demomicro.exception.ProductNotFoundException;
import com.example.demomicro.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> allProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("product/{uniq_id}")
    public Product productByUniqId(@PathVariable String uniq_id){
        log.info("Response with " + uniq_id + "product");
        return productService.findProductByUniqId(uniq_id).orElseThrow(() -> new ProductNotFoundException("Product with code ["+ uniq_id +"] doesn't exist"));
    }

    @GetMapping("products/{sku}")
    public List<Product> productBySku(@PathVariable String sku){
        log.info("Response with " + sku + "product");
        return productService.findProductsBySku(sku);
    }

}
