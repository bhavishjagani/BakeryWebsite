package com.Bakery.BlueberryBakery.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private double totalAmount;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private String shippingAddress;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String orderStatus;

    @Column
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
        this.createdAt = LocalDateTime.now();
        this.orderStatus = "pending";
    }
    public Order(String username, double totalAmount) {
        this.username = username;
        this.totalAmount = totalAmount;
        this.createdAt = LocalDateTime.now();
        this.orderStatus = "pending";
    }

    public void addItem(OrderItem item) {
        //OrderItem item = new OrderItem(this, product, quantity, product.getPrice());
        items.add(item);
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public LocalDateTime getOrderDate() { return createdAt; }
    public double getTotalAmount() { return totalAmount; }
    public List<OrderItem> getItems() { return items; }
    public void setUser(User user) { this.user = user; }

    public Payment getPayment(){return payment;}
}