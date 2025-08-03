package com.Bakery.BlueberryBakery.repo;

import com.Bakery.BlueberryBakery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}