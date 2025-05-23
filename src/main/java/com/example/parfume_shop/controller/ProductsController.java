package com.example.parfume_shop.controller;

import com.example.parfume_shop.DB.ProductEntity;
import com.example.parfume_shop.DB.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
