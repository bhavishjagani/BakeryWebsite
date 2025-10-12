// src/main/java/com/Bakery/BlueberryBakery/controller/CartController.java
package com.Bakery.BlueberryBakery.controller;

import com.Bakery.BlueberryBakery.model.Cart;
import com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.repo.CartRepository;
import com.Bakery.BlueberryBakery.repo.ProductRepository;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.NoSuchElementException;

@Controller
public class CartController {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartController(CartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    // GET /cart: load cart + initialize items while TX is open, then pass plain list to the view
    @GetMapping("/cart")
    @Transactional(readOnly = true)
    public String showCart(Model model, Principal principal) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();

        // load cart with items or create a fresh one
        Cart cart = cartRepository.findByUsername(username)
                .orElseGet(() -> {
                    User user = userRepository.findByUsername(username);
                    if (user == null) {
                        throw new NoSuchElementException("User not found: " + username);
                    }
                    Cart newCart = new Cart(username);
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        // initialize lazy collection within TX
        cart.getCartItems().size();

        model.addAttribute("cartItems", cart.getCartItems());
        model.addAttribute("total", cart.getTotal());
        return "cart";
    }

    // POST /add-to-cart: keep TX open while mutating lazy list
    @PostMapping("/add-to-cart")
    @Transactional
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam(name = "quantity", defaultValue = "1") int quantity,
                            Principal principal) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();

        Cart cart = cartRepository.findByUsername(username)
                .orElseGet(() -> {
                    User user = userRepository.findByUsername(username);
                    if (user == null) {
                        throw new NoSuchElementException("User not found: " + username);
                    }
                    Cart newCart = new Cart(username);
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        // find product inside TX
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + productId));

        cart.addProduct(product, Math.max(1, quantity));
        cartRepository.save(cart);
        return "redirect:/cart";
    }

    // Optional: remove item mapping to match your template's /delete
    @PostMapping("/delete")
    @Transactional
    public String deleteFromCart(@RequestParam("productId") Long productId, Principal principal) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        Cart cart = cartRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("Cart not found"));

        // remove first matching item
        cart.getCartItems().removeIf(ci -> ci.getProduct().getId().equals(productId));
        cartRepository.save(cart);
        return "redirect:/cart";
    }
}
