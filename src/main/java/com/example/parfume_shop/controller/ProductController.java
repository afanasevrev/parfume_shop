package com.example.parfume_shop.controller;

import com.example.parfume_shop.DB.ProductEntity;
import com.example.parfume_shop.DB.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<String> addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile imageFile
    ) {
        try {
            byte[] imageBytes = imageFile.getBytes();

            ProductEntity product = new ProductEntity(name, price, imageBytes);
            productRepository.save(product);

            return ResponseEntity.ok("Продукт успешно добавлен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка добавления продукта: " + e.getMessage());
        }
    }


}
