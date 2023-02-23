package com.autoFit.demo.repository;

import com.autoFit.demo.model.AddressModel;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Integer> {

    @Query("select u.id From AddressModel u WHERE u.user.id =:n")
    List<Integer> findAddressId(@Param("n") int userId);

}
