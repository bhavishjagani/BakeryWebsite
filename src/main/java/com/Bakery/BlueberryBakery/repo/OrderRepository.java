package com.Bakery.BlueberryBakery.repo;

import com.Bakery.BlueberryBakery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUsernameOrderByOrderDateDesc(String username);
}