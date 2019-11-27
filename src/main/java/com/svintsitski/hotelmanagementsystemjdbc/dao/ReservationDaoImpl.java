package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;
import com.svintsitski.hotelmanagementsystemjdbc.model.ReservationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Reservation> getAll() {
        String query = "SELECT * from hotel_iteration WHERE iteration_type='bron'";
        RowMapper<Reservation> rowMapper = new ReservationRowMapper();
        List<Reservation> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    public List<Reservation> getFreeApart(String startDate, String finalDate) {
        String query = "SELECT * from hotel_iteration WHERE ? < final_date and ? > start_date";
        RowMapper<Reservation> rowMapper = new ReservationRowMapper();
        List<Reservation> list = jdbcTemplate.query(query, rowMapper, startDate, finalDate);
        return list;
    }

    @Override
    public Reservation findById(int id) {
        String query = "SELECT * FROM hotel_iteration WHERE id = ?";
        RowMapper<Reservation> rowMapper = new ReservationRowMapper();
        Reservation reservation = jdbcTemplate.queryForObject(query, rowMapper, id);
        return reservation;
    }

    @Override
    public void add(Reservation reservation) {
        String query = "INSERT INTO hotel_iteration(id, start_date, final_date, user_id, room, iteration_type)" +
                " VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, reservation.getId(), reservation.getStart_date(), reservation.getFinal_date(),
                reservation.getUser_id(), reservation.getRoom(), reservation.getIteration_type());
    }

    @Override
    public void update(Reservation reservation) {
        String query = "UPDATE hotel_iteration SET start_date=?, final_date=?, user_id=?, room=?, iteration_type=? " +
                "WHERE id=?";
        jdbcTemplate.update(query, reservation.getStart_date(), reservation.getFinal_date(),
                reservation.getUser_id(), reservation.getRoom(), reservation.getIteration_type(), reservation.getId());
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM hotel_iteration WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}
