package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.Cart;


public interface CartService {
    void createCart(Cart cart);
    Cart getCartById(Long id);
    Cart getCartByUsername(String username);
    void deleteCart(Long id);
    void updateCart(Cart cart);
}