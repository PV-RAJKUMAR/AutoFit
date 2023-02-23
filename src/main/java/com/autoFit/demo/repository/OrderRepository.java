package com.autoFit.demo.repository;

import com.autoFit.demo.model.CartModel;
import com.autoFit.demo.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
    @Query("SELECT u FROM OrderModel u where u.cart.id = :n")
    List<OrderModel> OrderModelList(@Param("n") int cartId);

    @Query("SELECT r.partId FROM OrderModel r where r.cart.id = :n")
    List<Integer> findPartIds(@Param("n") int cartId);

    @Query("SELECT u.id FROM OrderModel u where u.cart.id = :n")
    List<Integer> OrderModelIds(@Param("n") int cartId);
}
