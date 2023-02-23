package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.UserDao;
import com.autoFit.demo.model.UserModel;
import com.autoFit.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public void save(UserModel user) {
        userDao.save(user);
    }

    public List<UserModel> listAll() {
        return userDao.findAll();
    }

    public UserModel get(int id) {
        return userDao.get(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public UserModel findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public List<UserModel> findInactiveUsers() {
        return userDao.findInactiveUsers();
    }

}
