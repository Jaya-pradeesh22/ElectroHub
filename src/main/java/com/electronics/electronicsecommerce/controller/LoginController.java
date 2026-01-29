package com.electronics.electronicsecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session) {
        // Simple auth (replace with real DB later)
        if (username.equals("user") && password.equals("1234")) {
            session.setAttribute("user", username);
            return "redirect:/cart";
        }
        return "login"; // Stay on login page
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
