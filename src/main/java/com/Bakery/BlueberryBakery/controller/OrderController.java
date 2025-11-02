package com.Bakery.BlueberryBakery.controller;

import com.Bakery.BlueberryBakery.model.Order;
import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import com.Bakery.BlueberryBakery.service.impl.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    public OrderController(OrderService orderService, UserRepository userRepository) {
        this.orderService = orderService;
        this.userRepository = userRepository;
    }

    @PostMapping("/checkout")
    public String checkout (Principal principal) {
        if (principal == null) return "redirect:/login";
        User user = userRepository.findByUsername(principal.getName());
        orderService.createOrder(user);
        return "redirect:/orders/history";
    }

    @GetMapping("/orders/history")
    public String viewOrderHistory(Principal principal, Model model) {
        if (principal == null) return "redirect:/login";
        List<Order> orders = orderService.getOrdersForUser(principal.getName());
        model.addAttribute("orders", orders);
        return "order-history";
    }
}