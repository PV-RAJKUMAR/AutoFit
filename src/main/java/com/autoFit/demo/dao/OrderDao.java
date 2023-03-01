package com.autoFit.demo.dao;

import com.autoFit.demo.model.OrderModel;

import java.util.List;

public interface OrderDao
{
    public void save(OrderModel orderModel);

    public List<OrderModel> findAll();

    public OrderModel get(int id);

    public void delete(int id);

    public List<OrderModel> OrderModelList(int cartId);

    public List<Integer> findPartIds(int cartId) ;

    public List<Integer> OrderModelIds(int cartId) ;

    public void delete(OrderModel orderModel);
}
