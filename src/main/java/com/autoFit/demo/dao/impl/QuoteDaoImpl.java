package com.autoFit.demo.dao.impl;

import com.autoFit.demo.dao.QuoteDao;
import com.autoFit.demo.model.QuoteModel;
import com.autoFit.demo.model.SparePartModel;
import com.autoFit.demo.repository.QuoteRepository;
import com.autoFit.demo.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuoteDaoImpl implements QuoteDao {
    @Autowired
    QuoteRepository quoteRepository;

    public void save(QuoteModel quoteModel) {
        quoteRepository.save(quoteModel);
    }

    public List<QuoteModel> findAll() {
        return quoteRepository.findAll();
    }

    public QuoteModel get(int id) {
        return quoteRepository.findById(id).get();
    }

    public void delete(int id) {
        quoteRepository.deleteById(id);
    }

    public List<QuoteModel> findPendingQuoteModelList() {
        return quoteRepository.findPendingQuoteModelList();
    }

    public List<QuoteModel> getQuoteList(int cartId) {
        return quoteRepository.getQuoteList(cartId);
    }
}
