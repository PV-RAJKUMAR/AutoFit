package com.autoFit.demo.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "partId")
    private int partId;
    @Column(name = "qty")
    private int quantity;
    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "cartId", nullable = false, referencedColumnName = "id")
    private CartModel cart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }
}
