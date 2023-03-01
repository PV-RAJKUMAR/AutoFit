package com.autoFit.demo.service;

import com.autoFit.demo.model.OrderModel;

import java.util.List;

public interface OrderService {
    public void save(OrderModel orderModel);

    public List<OrderModel> listAll();

    public OrderModel get(int id);

    public void delete(int id);

    public List<OrderModel> OrderModelList(int cartId);

    public List<Integer> findPartIds(int cartId);

    public List<Integer> OrderModelIds(int cartId);

    public void delete(OrderModel orderModel);
}
