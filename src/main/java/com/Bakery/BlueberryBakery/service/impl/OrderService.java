package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.Order;
import com.Bakery.BlueberryBakery.model.User;
import java.util.List;

public interface OrderService {
    Order createOrder(User user);
    List<Order> getOrdersForUser(String username);
}
