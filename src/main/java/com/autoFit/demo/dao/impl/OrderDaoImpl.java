package com.autoFit.demo.dao.impl;

import com.autoFit.demo.dao.OrderDao;
import com.autoFit.demo.model.OrderModel;
import com.autoFit.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Autowired
    OrderRepository orderRepository;

    public void save(OrderModel orderModel) {
        orderRepository.save(orderModel);
    }

    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    public OrderModel get(int id) {
        return orderRepository.findById(id).get();
    }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public List<OrderModel> OrderModelList(int cartId) {
        return orderRepository.OrderModelList(cartId);
    }

    public List<Integer> findPartIds(int cartId) {
        return orderRepository.findPartIds(cartId);
    }

    public List<Integer> OrderModelIds(int cartId) {
        return orderRepository.OrderModelIds(cartId);
    }

    public void delete(OrderModel orderModel) {
        orderRepository.delete(orderModel);
    }
}
