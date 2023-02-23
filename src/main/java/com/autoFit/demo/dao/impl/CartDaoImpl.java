package com.autoFit.demo.dao.impl;

import com.autoFit.demo.dao.CartDao;
import com.autoFit.demo.model.CartModel;
import com.autoFit.demo.model.UserModel;
import com.autoFit.demo.repository.CartRepository;
import com.autoFit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartDaoImpl implements CartDao {
    @Autowired
    CartRepository cartRepository;

    public void save(CartModel cartModel) {
        cartRepository.save(cartModel);
    }

    public List<CartModel> findAll() {
        return cartRepository.findAll();
    }

    public CartModel get(int id) {
        return cartRepository.findById(id).get();
    }

    public void delete(int id) {
        cartRepository.deleteById(id);
    }

    public List<CartModel> getPendingStatusList() {
        return cartRepository.getPendingStatusList();
    }

    public List<CartModel> findUserCartList(int userId) {
        return cartRepository.findUserCartList(userId);
    }
}
