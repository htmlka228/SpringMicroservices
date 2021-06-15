package com.example.demomicro.repository;

import com.example.demomicro.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUniqId(String uniq_id);
    List<Product> findAllBySku(String sku);
}
