package com.electronics.electronicsecommerce.service;

import com.electronics.electronicsecommerce.model.CartItem;
import com.electronics.electronicsecommerce.model.Product;
import java.util.*;

public class ShoppingCart {
    private Map<String, CartItem> cartItems = new HashMap<>();

    public void addItem(CartItem item) {
        String productKey = item.getProduct().getName();
        if (cartItems.containsKey(productKey)) {
            CartItem existing = cartItems.get(productKey);
            existing.setQuantity(existing.getQuantity() + 1);
        } else {
            cartItems.put(productKey, item);
        }
    }

    public void increment(String productName) {
        CartItem item = cartItems.get(productName);
        if (item != null) {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void decrement(String productName) {
        CartItem item = cartItems.get(productName);
        if (item != null) {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
            } else {
                cartItems.remove(productName);
            }
        }
    }

    public void removeItem(String productName) {
        cartItems.remove(productName);
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems.values());
    }

    public double getTotalAmount() {
        return cartItems.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}
