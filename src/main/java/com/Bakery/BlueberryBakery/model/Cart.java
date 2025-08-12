package com.Bakery.BlueberryBakery.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem (Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class Cart {
    private final Map<Long, CartItem> items = new LinkedHashMap<>();

    private void add(Product p) {
        CartItem exists = items.get(p.getId());
        if (exists == null) {
            items.put(p.getId(), new CartItem(p, 1));
        }
        else {
            exists.setQuantity(exists.getQuantity()+1);
        }
    }
}