package com.autoFit.demo.service.impl;

import com.autoFit.demo.dao.QuoteDao;
import com.autoFit.demo.dao.SparePartDao;
import com.autoFit.demo.model.QuoteModel;
import com.autoFit.demo.model.SparePartModel;
import com.autoFit.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuoteServiceImpl implements QuoteService {
    @Autowired
    QuoteDao quoteDao;

    public void save(QuoteModel quoteModel) {
        quoteDao.save(quoteModel);
    }

    public List<QuoteModel> listAll() {
        return quoteDao.findAll();
    }

    public QuoteModel get(int id) {
        return quoteDao.get(id);
    }

    public void delete(int id) {
        quoteDao.delete(id);
    }

    public List<QuoteModel> findPendingQuoteModelList() {
        return quoteDao.findPendingQuoteModelList();
    }

    public List<QuoteModel> getQuoteList(int cartId) {
        return quoteDao.getQuoteList(cartId);
    }
}
