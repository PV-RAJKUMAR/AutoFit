package com.autoFit.demo.repository;

import com.autoFit.demo.model.CartModel;
import com.autoFit.demo.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer> {

    @Query("SELECT u FROM CartModel u where u.status ='pending'")
    List<CartModel> getPendingStatusList();

    @Query("SELECT u FROM CartModel u where u.user.id = :n and u.status !='new'")
    List<CartModel>findUserCartList(@Param("n") int userId);
}
