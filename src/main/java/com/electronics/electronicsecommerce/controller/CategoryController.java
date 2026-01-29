package com.electronics.electronicsecommerce.controller;
import com.electronics.electronicsecommerce.model.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @GetMapping("/category/{categoryName}")
    public String categoryPage(@PathVariable String categoryName, Model model) {
        model.addAttribute("category", categoryName);
        model.addAttribute("products", getProductsByCategory(categoryName));
        return "category";
    }

    private List<Product> getProductsByCategory(String category) {
        // Static data for MVP - Replace with DB later
        return switch (category.toLowerCase()) {
            case "smartphones" -> List.of(
                    new Product("iPhone 16 Pro", "$999", "/images/iphone16.jpg"),
                    new Product("Samsung S25 Ultra", "$1299", "/images/samsung.jpg")
            );
            case "televisions" -> List.of(
                    new Product("Samsung QLED 65\"", "$1499", "/images/samsung-qled.jpg"),
                    new Product("LG OLED C4", "$1999", "/images/lgoled.jpg")
            );
            case "bluetooth" -> List.of(
                    new Product("AirPods Pro 2", "$249", "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400"),
                    new Product("Sony WF-1000XM5", "$299", "/images/sony.jpg")
            );
            case "cameras" -> List.of(
                    new Product("Sony A7 IV", "$2499", "/images/sonydslr.jpg"),
                    new Product("Canon EOS R6", "$1999", "/images/canon.jpg")
            );
            case "gaming" -> List.of(
                    new Product("PS5 Slim", "$499", "/images/ps5.jpg"),
                    new Product("Xbox Series X", "$499", "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=400")
            );
            case "laptops" -> List.of(
                    new Product("MacBook Pro M3", "$1999", "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400"),
                    new Product("Dell XPS 15", "$1799", "/images/dell.jpg")
            );
            default -> List.of();
        };
    }
}
