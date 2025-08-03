package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product p);

    List<Product> findAll();
}