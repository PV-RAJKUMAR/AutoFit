package com.autoFit.demo.repository;

import com.autoFit.demo.model.QuoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteModel, Integer> {

    @Query("select u From QuoteModel u WHERE u.status ='pending'")
    List<QuoteModel> findPendingQuoteModelList();

    @Query("select u From QuoteModel u WHERE u.cart.id =:n")
    List<QuoteModel> getQuoteList(@Param("n") int cartId);
}
