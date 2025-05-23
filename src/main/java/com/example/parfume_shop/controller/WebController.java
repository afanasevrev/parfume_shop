package com.example.parfume_shop.controller;

import com.example.parfume_shop.DB.ProductEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    private String getIndex() {
        return "index";
    }
    @GetMapping("/product")
    private String getProductForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "product";
    }
}
