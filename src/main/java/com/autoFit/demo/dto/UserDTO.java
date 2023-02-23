package com.autoFit.demo.dto;

import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.model.CartModel;

import java.util.Set;

public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int age;
    private String gender;
    private String phoneNo;
    private boolean active;
    private String role;
    private Set<AddressDTO> addressModelList;
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

    public Set<AddressDTO> getAddressModelList() {
        return addressModelList;
    }

    public void setAddressModelList(Set<AddressDTO> addressModelList) {
        this.addressModelList = addressModelList;
    }

    public Set<CartModel> getCartModelList() {
        return cartModelList;
    }

    public void setCartModelList(Set<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }
}
