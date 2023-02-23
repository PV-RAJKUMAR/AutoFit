package com.autoFit.demo.repository;

import com.autoFit.demo.model.AddressModel;
import com.autoFit.demo.model.CartModel;
import com.autoFit.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByUserName(String userName);

    @Query("select u From UserModel u WHERE u.role ='ROLE_USER' and u.active='0'")
    List<UserModel> findInactiveUsers();

}
