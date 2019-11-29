package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Review;
import com.svintsitski.hotelmanagementsystemjdbc.model.ReviewRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Review> getAll() {
        String query = "SELECT * from reviews";
        RowMapper<Review> rowMapper = new ReviewRowMapper();
        List<Review> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    @Override
    public Review findById(int id) {
        String query = "SELECT * FROM reviews WHERE id = ?";
        RowMapper<Review> rowMapper = new ReviewRowMapper();
        Review review = jdbcTemplate.queryForObject(query, rowMapper, id);
        return review;
    }

    @Override
    public void add(Review review) {
        String query = "INSERT INTO reviews(id, `user_id`, text, mark) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(query, review.getId(), review.getUser_id(), review.getText(), review.getMark());
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM reviews WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}
