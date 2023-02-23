package com.autoFit.demo.dao;

import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.model.UserModel;

import java.util.List;
import java.util.Set;

public interface UserDao
{
    public void save(UserModel user);

    public List<UserModel> findAll();

    public UserModel get(int id);

    public void delete(int id);

    public UserModel findByUserName(String userName);

    List<UserModel> findInactiveUsers();

}
