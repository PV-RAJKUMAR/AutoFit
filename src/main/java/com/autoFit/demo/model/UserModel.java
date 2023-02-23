package com.autoFit.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "active")
    private boolean active;
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<AddressModel> addressModelList;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<CartModel> cartModelList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<AddressModel> getAddressModelList() {
        return addressModelList;
    }

    public void setAddressModelList(Set<AddressModel> addressModelList) {
        this.addressModelList = addressModelList;
    }

    public Set<CartModel> getCartModelList() {
        return cartModelList;
    }

    public void setCartModelList(Set<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }
}
