package com.autoFit.demo.dao;

import com.autoFit.demo.model.QuoteModel;

import java.util.List;

public interface QuoteDao {
    public void save(QuoteModel quoteModel);

    public List<QuoteModel> findAll();

    public QuoteModel get(int id);

    public void delete(int id);

    public List<QuoteModel> findPendingQuoteModelList();

    public List<QuoteModel> getQuoteList(int cartId);
}
