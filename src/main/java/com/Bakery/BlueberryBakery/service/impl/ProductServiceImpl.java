package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.Product;
import com.Bakery.BlueberryBakery.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product save(Product p) {
        return repo.save(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new java.util.NoSuchElementException("Product not found: " + id));
    }
}
