package com.autoFit.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "quote_req")
public class QuoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "req_quote")
    private double reqQuote;
    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "cartId", nullable = false, referencedColumnName = "id")
    private CartModel cart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getReqQuote() {
        return reqQuote;
    }

    public void setReqQuote(double reqQuote) {
        this.reqQuote = reqQuote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
