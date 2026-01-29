package com.electronics.electronicsecommerce.controller;

import com.electronics.electronicsecommerce.model.Product;
import com.electronics.electronicsecommerce.model.CartItem;
import com.electronics.electronicsecommerce.service.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private ShoppingCart cart = new ShoppingCart();

    @GetMapping
    public String cartPage(Model model) {
        model.addAttribute("cartItems", cart.getCartItems());
        model.addAttribute("totalAmount", cart.getTotalAmount());
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(
            @RequestParam("productName") String productName,
            @RequestParam("price") String price,
            @RequestParam("image") String image) {
        Product product = new Product(productName, price, image);
        cart.addItem(new CartItem(product, 1));
        return "redirect:/cart";
    }

    @PostMapping("/increment")
    public String increment(@RequestParam("productName") String productName) {
        cart.increment(productName);
        return "redirect:/cart";
    }

    @PostMapping("/decrement")
    public String decrement(@RequestParam("productName") String productName) {
        cart.decrement(productName);
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("productName") String productName) {
        cart.removeItem(productName);
        return "redirect:/cart";
    }
}
