package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.SparePartDao;
import com.autoFit.demo.dao.UserDao;
import com.autoFit.demo.model.SparePartModel;
import com.autoFit.demo.model.UserModel;
import com.autoFit.demo.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SparePartServiceImpl implements SparePartService {
    @Autowired
    SparePartDao sparePartDao;

    public void save(SparePartModel sparePartModel) {
        sparePartDao.save(sparePartModel);
    }

    public List<SparePartModel> listAll() {
        return sparePartDao.findAll();
    }

    public SparePartModel get(int id) {
        return sparePartDao.get(id);
    }

    public void delete(int id) {
        sparePartDao.delete(id);
    }

    public List<SparePartModel> findBySuitedVhl(String carBrand) {
        return sparePartDao.findBySuitedVhl(carBrand);
    }
}
