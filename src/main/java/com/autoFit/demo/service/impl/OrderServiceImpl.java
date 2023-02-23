package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.OrderDao;
import com.autoFit.demo.dao.QuoteDao;
import com.autoFit.demo.model.OrderModel;
import com.autoFit.demo.model.QuoteModel;
import com.autoFit.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    public void save(OrderModel orderModel) {
        orderDao.save(orderModel);
    }

    public List<OrderModel> listAll() {
        return orderDao.findAll();
    }

    public OrderModel get(int id) {
        return orderDao.get(id);
    }

    public void delete(int id) {
        orderDao.delete(id);
    }

    public List<OrderModel> OrderModelList(int cartId) {
        return orderDao.OrderModelList(cartId);
    }

    public List<Integer> findPartIds(int cartId) {
        return orderDao.findPartIds(cartId);
    }

    public List<Integer> OrderModelIds(int cartId) {
        return orderDao.OrderModelIds(cartId);
    }
}
