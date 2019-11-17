package com.svintsitski.hotelmanagementsystemjdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        Review review = new Review();
        review.setId(resultSet.getInt("id"));
        review.setUser_id(resultSet.getInt("user_id"));
        review.setText(resultSet.getString("text"));
        review.setMark(resultSet.getInt("mark"));
        return review;
    }
}
