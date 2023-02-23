package com.autoFit.demo.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "status")
    private String status;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "approved_amt")
    private double approvedAmount;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private Set<OrderModel> orderModelList;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private Set<QuoteModel> quoteModelList;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserModel user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Set<OrderModel> getOrderModelList() {
        return orderModelList;
    }

    public void setOrderModelList(Set<OrderModel> orderModelList) {
        this.orderModelList = orderModelList;
    }

    public Set<QuoteModel> getQuoteModelList() {
        return quoteModelList;
    }

    public void setQuoteModelList(Set<QuoteModel> quoteModelList) {
        this.quoteModelList = quoteModelList;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
