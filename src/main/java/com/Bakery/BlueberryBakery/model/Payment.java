package com.Bakery.BlueberryBakery.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false, unique = true)
    private String stripePaymentIntentID;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String receiptURL;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column(length = 1000)
    private String errorMessage;

    public Payment() {
        this.createdAt = LocalDateTime.now();
        this.paymentStatus = "pending";
    }

    public Payment(Order order, String stripePaymentIntentID, double amount, String currency) {
        this.order = order;
        this.stripePaymentIntentID = stripePaymentIntentID;
        this.amount = amount;
        this.currency = currency;
        this.createdAt = LocalDateTime.now();
        this.paymentStatus = "pending";
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStripePaymentIntentID() {
        return stripePaymentIntentID;
    }

    public void setStripePaymentIntentID(String stripePaymentIntentID) {
        this.stripePaymentIntentID = stripePaymentIntentID;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReceiptURL() {
        return receiptURL;
    }

    public void setReceiptURL(String receiptURL) {
        this.receiptURL = receiptURL;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}