package com.autoFit.demo.dao.impl;

import com.autoFit.demo.dao.AddressDao;
import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Autowired
    AddressRepository addressRepository;

    public void save(AddressModel addressModel) {
        addressRepository.save(addressModel);
    }

    public List<AddressModel> findAll() {
        return addressRepository.findAll();
    }

    public AddressModel get(int id) {
        return addressRepository.findById(id).get();
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    public List<Integer> findAddressId(int userId) {
        return addressRepository.findAddressId(userId);
    }
}
