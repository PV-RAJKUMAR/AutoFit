package com.autoFit.demo.service;

import com.autoFit.demo.model.CartModel;

import java.util.List;

public interface CartService {
    public void save(CartModel cartModel);

    public List<CartModel> listAll();

    public CartModel get(int id);

    public void delete(int id);

    public List<CartModel> getPendingStatusList();

    public List<CartModel> findUserCartList(int userId);

}
