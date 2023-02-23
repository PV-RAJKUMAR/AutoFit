package com.autoFit.demo.service;

import com.autoFit.demo.model.UserModel;

import java.util.List;

public interface UserService {
    public void save(UserModel user);

    public List<UserModel> listAll();

    public UserModel get(int id);

    public void delete(int id);

    public UserModel findByUserName(String userName);

    public List<UserModel> findInactiveUsers();

}
