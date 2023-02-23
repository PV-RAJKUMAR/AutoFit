package com.autoFit.demo.dao;

import com.autoFit.demo.model.CartModel;

import java.util.List;

public interface CartDao {
    public void save(CartModel cartModel);

    public List<CartModel> findAll();

    public CartModel get(int id);

    public void delete(int id);

    public List<CartModel> getPendingStatusList();

    public List<CartModel> findUserCartList(int userId);
}
