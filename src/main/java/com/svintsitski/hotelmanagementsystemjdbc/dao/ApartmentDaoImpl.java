package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.model.ApartmentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ApartmentDaoImpl implements ApartmentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Apartment> getAll() {
        String query = "SELECT * from rooms";
        RowMapper<Apartment> rowMapper = new ApartmentRowMapper();
        List<Apartment> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    @Override
    public Apartment findById(int id) {
        String query = "SELECT * FROM rooms WHERE id = ?";
        RowMapper<Apartment> rowMapper = new ApartmentRowMapper();
        Apartment apartment = jdbcTemplate.queryForObject(query, rowMapper, id);
        return apartment;
    }

    @Override
    public void add(Apartment apartment) {
        String query = "INSERT INTO rooms(id, userCells, roomCells, price) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(query, apartment.getId(), apartment.getUserCells(), apartment.getRoomCells(),
                apartment.getPrice());

    }

    @Override
    public void update(Apartment apartment) {
        String query = "UPDATE rooms SET userCells=?, roomCells=?, price=? WHERE id=?";
        jdbcTemplate.update(query, apartment.getUserCells(), apartment.getRoomCells(), apartment.getPrice(),
                apartment.getId());
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM rooms WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}
