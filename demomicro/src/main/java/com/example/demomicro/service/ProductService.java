package com.example.demomicro.service;

import com.example.demomicro.entity.Product;
import com.example.demomicro.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductByUniqId(String uniq_id) {
        return productRepository.findByUniqId(uniq_id);
    }

    public List<Product> findProductsBySku(String sku){
        return productRepository.findAllBySku(sku);
    }
}

