package com.Bakery.BlueberryBakery.controller;

import com.Bakery.BlueberryBakery.model.Cart;
import com.Bakery.BlueberryBakery.model.CartItem;
import com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.service.impl.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        model.addAttribute("cartItems", cart.getCartItems());
        model.addAttribute("total", cart.getTotal());
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        Product product = productService.getProductById(productId);
        if (product != null) {
            cart.addProduct(product, 1);
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/delete")
    public String removeFromCart(@RequestParam Long productId, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cart.getCartItems().removeIf(item -> item.getProduct().getId().equals(productId));
        }
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }
}