package com.autoFit.demo.dao.impl;

import com.autoFit.demo.dao.UserDao;
import com.autoFit.demo.model.UserModel;
import com.autoFit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    public void save(UserModel user) {
        userRepository.save(user);
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel get(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public UserModel findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<UserModel> findInactiveUsers() {
        return userRepository.findInactiveUsers();
    }

}
