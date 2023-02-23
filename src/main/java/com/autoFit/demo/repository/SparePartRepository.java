package com.autoFit.demo.repository;

import com.autoFit.demo.model.SparePartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SparePartRepository extends JpaRepository<SparePartModel, Integer> {
    List<SparePartModel> findBySuitedVhl(String suitedVhl);
}
