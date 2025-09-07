package com.Bakery.BlueberryBakery.repo;

import com.Bakery.BlueberryBakery.model.Cart;
import com.Bakery.BlueberryBakery.model.CartItem;
import com.Bakery.BlueberryBakery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}