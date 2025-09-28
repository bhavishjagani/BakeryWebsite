package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.Cart;
import com.Bakery.BlueberryBakery.repo.CartRepository;
import com.Bakery.BlueberryBakery.service.impl.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    @Transactional(readOnly = true)
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Cart getCartByUsername(String username) {
        return cartRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Cart not found for username: " + username));
    }

    @Override
    public void deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cart not found with id: " + id);
        }
    }

    @Override
    public void updateCart(Cart cart) {
        if (cart.getId() == null || !cartRepository.existsById(cart.getId())) {
            throw new RuntimeException("Cart not found or ID missing for update");
        }
        cartRepository.save(cart);
    }
}