package com.autoFit.demo.service;

import com.autoFit.demo.model.AddressModel;

import java.util.List;

public interface AddressService {
    public void save(AddressModel addressModel);

    public List<AddressModel> listAll();

    public AddressModel get(int id);

    public void delete(int id);

    public List<Integer> findAddressId(int userId);
}
