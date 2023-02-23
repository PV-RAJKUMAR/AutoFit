package com.autoFit.demo.service;

import com.autoFit.demo.model.QuoteModel;

import java.util.List;

public interface QuoteService {
    public void save(QuoteModel quoteModel);

    public List<QuoteModel> listAll();

    public QuoteModel get(int id);

    public void delete(int id);

    public List<QuoteModel> findPendingQuoteModelList();

    public List<QuoteModel> getQuoteList(int cartId);
}
