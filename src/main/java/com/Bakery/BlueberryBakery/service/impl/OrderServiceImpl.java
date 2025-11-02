package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.*;
import com.Bakery.BlueberryBakery.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepo  sitory;
    }

    @Override
    public Order createOrder(User user) {
        Cart cart = cartRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Order order = new Order(user.getUsername(), user.);
        cart.getCartItems().forEach(item ->
                order.addItem(item.getProduct(), item.getQuantity()));

        cart.getCartItems().clear();
        cartRepository.save(cart);

        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrdersForUser(String username) {
        return orderRepository.findByUsernameOrderByOrderDateDesc(username);
    }
}