package com.autoFit.demo.dao;

import com.autoFit.demo.model.SparePartModel;

import java.util.List;

public interface SparePartDao {
    public void save(SparePartModel sparePartModel);

    public List<SparePartModel> findAll();

    public SparePartModel get(int id);

    public void delete(int id);

    public List<SparePartModel> findBySuitedVhl(String carBrand);
}
