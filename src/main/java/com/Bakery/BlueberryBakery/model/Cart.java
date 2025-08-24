package com.Bakery.BlueberryBakery.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private final Map<Long, CartItem> items = new LinkedHashMap<>();

    public void add(Product p) {
        CartItem exists = items.get(p.getId());
        if (exists == null) {
            items.put(p.getId(), new CartItem(p, 1));
        } else {
            exists.setQuantity(exists.getQuantity() + 1);
        }
    }

    public void remove(Product p) {
        CartItem exists = items.get(p.getId());
        if (exists != null) {
            if (exists.getQuantity() > 1) {
                exists.setQuantity(exists.getQuantity() - 1);
            } else {
                items.remove(p.getId());
            }
        }
    }

    public Map<Long, CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return items.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}