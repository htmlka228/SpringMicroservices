package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.entity.ProductAvailable;
import com.example.productservice.entity.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final RestTemplate restTemplate;

    public List<?> getProduct(){
        ResponseEntity<Product[]> productsResponse =
                restTemplate.getForEntity("http://catalog-service/api/products", Product[].class);

        ResponseEntity<ProductAvailable[]> inventoryResponse =
                restTemplate.getForEntity("http://inventory-service/api/inventory", ProductAvailable[].class);

        List<Product> products = Arrays.stream(Objects.requireNonNull(productsResponse.getBody())).collect(Collectors.toList());
        List<ProductAvailable> inventory = Arrays.stream(Objects.requireNonNull(inventoryResponse.getBody())).collect(Collectors.toList());
        List<ProductDTO> clientProducts = new ArrayList<>();

        for (Product product : products) {
            clientProducts.add(new ProductDTO(product,
                                              inventory.stream().filter(e -> e.getUniq_id().equals(product.getUniqId())).findFirst().get().getAvailableQuantity()));
        }

        return clientProducts.stream().filter(e -> e.getAvailableQuantity() > 0).collect(Collectors.toList());
    }

    public List<?> getProductBySku(String sku){
        ResponseEntity<Product[]> productsResponse =
                restTemplate.getForEntity("http://catalog-service/api/products/{sku}", Product[].class, sku);

        ResponseEntity<ProductAvailable[]> inventoryResponse =
                restTemplate.getForEntity("http://inventory-service/api/inventory", ProductAvailable[].class);

        List<Product> products = Arrays.stream(Objects.requireNonNull(productsResponse.getBody())).collect(Collectors.toList());
        List<ProductAvailable> inventory = Arrays.stream(Objects.requireNonNull(inventoryResponse.getBody())).collect(Collectors.toList());
        List<ProductDTO> clientProducts = new ArrayList<>();

        for (Product product : products) {
            clientProducts.add(new ProductDTO(product,
                    inventory.stream().filter(e -> e.getUniq_id().equals(product.getUniqId())).findFirst().get().getAvailableQuantity()));
        }

        return clientProducts.stream().filter(e -> e.getAvailableQuantity() > 0).collect(Collectors.toList());
    }

}
