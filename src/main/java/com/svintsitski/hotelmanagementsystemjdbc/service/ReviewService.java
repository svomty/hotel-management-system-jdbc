package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();

    Review findById(int id);

    void add(Review review);

    void delete(int id);
}
