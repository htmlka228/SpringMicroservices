package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.entity.ProductAvailable;
import com.example.productservice.entity.ProductDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        List<Product> products = getCatalog();
        List<ProductAvailable> inventory = getInventory();
        List<ProductDTO> clientProducts = new ArrayList<>();

        if (products.isEmpty()) {
            return inventory;
        }
        if (inventory.isEmpty()) {
            return products;
        }

        for (Product product : products) {
            clientProducts.add(new ProductDTO(product,
                                              inventory.stream().filter(e -> e.getUniqId().equals(product.getUniqId())).findFirst().get().getAvailableQuantity()));
        }

        return clientProducts.stream().filter(e -> e.getAvailableQuantity() > 0).collect(Collectors.toList());
    }

    public List<?> getProductBySku(String sku){

        List<Product> products = getCatalogBySku(sku);
        List<ProductAvailable> inventory = getInventory();
        List<ProductDTO> clientProducts = new ArrayList<>();

        for (Product product : products) {
            clientProducts.add(new ProductDTO(product,
                    inventory.stream().filter(e -> e.getUniqId().equals(product.getUniqId())).findFirst().get().getAvailableQuantity()));
        }

        return clientProducts.stream().filter(e -> e.getAvailableQuantity() > 0).collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "defaultFallBack")
    private List<Product> getCatalog() {
        return restTemplate.exchange("http://API-GATEWAY:9191/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {})
                .getBody();

    }

    private List<Product> getCatalogBySku(String sku) {
        ResponseEntity<Product[]> productsResponse =
                restTemplate.getForEntity("http://catalog-service/api/products/{sku}", Product[].class, sku);

        return Arrays.stream(Objects.requireNonNull(productsResponse.getBody())).collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "defaultFallBack")
    private List<ProductAvailable> getInventory() {
        return restTemplate.exchange("http://inventory-service/api/inventory", HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductAvailable>>() {})
                .getBody();

    }

    @SuppressWarnings("unused")
    public List<?> defaultFallBack() {
        return Collections.emptyList();
    }
}
