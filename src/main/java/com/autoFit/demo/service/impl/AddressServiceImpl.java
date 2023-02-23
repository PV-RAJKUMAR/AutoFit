package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.AddressDao;
import com.autoFit.demo.dto.AddressDTO;
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

    public AddressDTO convertToDTO(AddressModel addressModel) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressModel.getId());
        addressDTO.setAddressLine1(addressModel.getAddressLine1());
        addressDTO.setAddressLine2(addressModel.getAddressLine2());
        addressDTO.setCity(addressModel.getCity());
        addressDTO.setState(addressModel.getState());
        addressDTO.setCountry(addressModel.getCountry());
        addressDTO.setPincode(addressModel.getPincode());
        return addressDTO;
    }

    public AddressModel convertToModel(AddressDTO addressDTO) {
        AddressModel addressModel = new AddressModel();
        addressModel.setId(addressDTO.getId());
        addressModel.setAddressLine1(addressDTO.getAddressLine1());
        addressModel.setAddressLine2(addressDTO.getAddressLine2());
        addressModel.setCity(addressDTO.getCity());
        addressModel.setState(addressDTO.getState());
        addressModel.setCountry(addressDTO.getCountry());
        addressModel.setPincode(addressDTO.getPincode());
        return addressModel;
    }
}
