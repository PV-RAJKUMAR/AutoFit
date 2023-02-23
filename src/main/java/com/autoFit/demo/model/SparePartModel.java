package com.autoFit.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "spare_part")
public class SparePartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "partNo")
    private String partNo;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "available_count")
    private int avlCount;
    @Column(name = "price")
    private double price;
    @Column(name = "car_manufacturer")
    private String suitedVhl;
    @Column(name = "is_available")
    private boolean is_available;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAvlCount() {
        return avlCount;
    }

    public void setAvlCount(int avlCount) {
        this.avlCount = avlCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSuitedVhl() {
        return suitedVhl;
    }

    public void setSuitedVhl(String suitedVhl) {
        this.suitedVhl = suitedVhl;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
