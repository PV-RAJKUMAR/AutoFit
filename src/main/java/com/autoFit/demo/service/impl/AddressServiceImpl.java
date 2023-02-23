package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.AddressDao;
import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    public void save(AddressModel addressModel) {
        addressDao.save(addressModel);
    }

    public List<AddressModel> listAll() {
        return addressDao.findAll();
    }

    public AddressModel get(int id) {
        return addressDao.get(id);
    }

    public void delete(int id) {
        addressDao.delete(id);
    }

    public List<Integer> findAddressId(int userId) {
        return addressDao.findAddressId(userId);
    }
}
