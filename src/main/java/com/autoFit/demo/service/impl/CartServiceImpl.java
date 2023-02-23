package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.CartDao;
import com.autoFit.demo.model.CartModel;
import com.autoFit.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;

    public void save(CartModel cartModel) {
        cartDao.save(cartModel);
    }

    public List<CartModel> listAll() {
        return cartDao.findAll();
    }

    public CartModel get(int id) {
        return cartDao.get(id);
    }

    public void delete(int id) {
        cartDao.delete(id);
    }

    public List<CartModel> getPendingStatusList() {
        return cartDao.getPendingStatusList();
    }

    public List<CartModel> findUserCartList(int userId) {
        return cartDao.findUserCartList(userId);
    }
}
