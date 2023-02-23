package com.autoFit.demo.dao;

import com.autoFit.demo.model.AddressModel;

import java.util.List;

public interface AddressDao {
    public void save(AddressModel addressModel);

    public List<AddressModel> findAll();

    public AddressModel get(int id);

    public void delete(int id);

    List<Integer> findAddressId(int userId);
}
