package com.svintsitski.hotelmanagementsystemjdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentRowMapper implements RowMapper<Apartment> {
    @Override
    public Apartment mapRow(ResultSet resultSet, int i) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setId(resultSet.getInt("id"));
        apartment.setUserCells(resultSet.getInt("userCells"));
        apartment.setRoomCells(resultSet.getInt("roomCells"));
        apartment.setPrice(resultSet.getBigDecimal("price"));
        return apartment;
    }
}
