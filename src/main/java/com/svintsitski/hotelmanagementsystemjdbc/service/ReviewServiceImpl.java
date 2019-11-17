package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.dao.ReviewDaoImpl;
import com.svintsitski.hotelmanagementsystemjdbc.dao.ZaseleniyeDaoImpl;
import com.svintsitski.hotelmanagementsystemjdbc.model.Review;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDaoImpl dao;

    @Override
    public List<Review> getAll() {
        return dao.getAll();
    }

    @Override
    public Review findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void add(Review review) {
        dao.add(review);
    }

    @Override
    public void update(Review review) {
        dao.update(review);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
