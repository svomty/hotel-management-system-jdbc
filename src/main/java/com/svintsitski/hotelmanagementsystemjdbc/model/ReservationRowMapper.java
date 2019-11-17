package com.svintsitski.hotelmanagementsystemjdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRowMapper implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt("id"));
        reservation.setStart_date(resultSet.getDate("start_date"));
        reservation.setFinal_date(resultSet.getDate("final_date"));
        reservation.setUser_id(resultSet.getInt("user_id"));
        reservation.setRoom(resultSet.getInt("room"));
        reservation.setIteration_type(resultSet.getString("iteration_type"));
        return reservation;
    }
}
