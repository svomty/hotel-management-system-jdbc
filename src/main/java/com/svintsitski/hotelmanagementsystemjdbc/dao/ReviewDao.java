package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Review;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;

import java.util.List;

public interface ReviewDao {
    List<Review> getAll();

    Review findById(int id);

    void add(Review review);

    void update(Review review);

    void delete(int id);
}
