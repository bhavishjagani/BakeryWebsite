package com.Bakery.BlueberryBakery.service.impl;
import com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product save(Product p) {
        return repo.save(p);
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }
}