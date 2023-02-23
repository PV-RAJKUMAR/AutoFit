package com.autoFit.demo.dao.impl;

import com.autoFit.demo.dao.SparePartDao;
import com.autoFit.demo.model.SparePartModel;
import com.autoFit.demo.model.UserModel;
import com.autoFit.demo.repository.SparePartRepository;
import com.autoFit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SparePartDaoImpl implements SparePartDao {
    @Autowired
    SparePartRepository sparePartRepository;

    public void save(SparePartModel sparePartModel) {
        sparePartRepository.save(sparePartModel);
    }

    public List<SparePartModel> findAll() {
        return sparePartRepository.findAll();
    }

    public SparePartModel get(int id) {
        return sparePartRepository.findById(id).get();
    }

    public void delete(int id) {
        sparePartRepository.deleteById(id);
    }

    public List<SparePartModel> findBySuitedVhl(String carBrand) {
        return sparePartRepository.findBySuitedVhl(carBrand);
    }
}
