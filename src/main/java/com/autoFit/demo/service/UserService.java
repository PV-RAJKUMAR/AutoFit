package com.autoFit.demo.service;

import com.autoFit.demo.dto.UserDTO;
import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.model.UserModel;

import java.util.List;
import java.util.Set;

public interface UserService {
    public void save(UserModel user);

    public List<UserModel> listAll();

    public UserModel get(int id);

    public void delete(int id);

    public UserModel findByUserName(String userName);

    public List<UserModel> findInactiveUsers();

}
