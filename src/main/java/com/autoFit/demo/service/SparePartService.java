package com.autoFit.demo.service;

import com.autoFit.demo.model.SparePartModel;

import java.util.List;

public interface SparePartService {
    public void save(SparePartModel sparePartModel);

    public List<SparePartModel> listAll();

    public SparePartModel get(int id);

    public void delete(int id);

    public List<SparePartModel> findBySuitedVhl(String carBrand);
}


