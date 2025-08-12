package com.Bakery.BlueberryBakery.controller;

import com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    private static List<String> cart = new ArrayList<>();

    @GetMapping("/cart")
    public String viewCart(Map<String, Object> model) {
        model.put("cart", cart);
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId) {
        Product product = ProductService.
//        cart.add(productName);
        return "redirect:/cart";
    }
}