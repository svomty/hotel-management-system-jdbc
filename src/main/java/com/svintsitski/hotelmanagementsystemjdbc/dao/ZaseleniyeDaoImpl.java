package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;
import com.svintsitski.hotelmanagementsystemjdbc.model.ZaseleniyeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ZaseleniyeDaoImpl implements ZaseleniyeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Zaseleniye> getAll() {
        String query = "SELECT * from hotel_iteration WHERE iteration_type='zaseleniye'";
        RowMapper<Zaseleniye> rowMapper = new ZaseleniyeRowMapper();
        List<Zaseleniye> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }


    public List<Zaseleniye> getFreeApart(String startDate, String finalDate) {
        String query = "SELECT * from hotel_iteration WHERE ? < final_date and ? > start_date";
        RowMapper<Zaseleniye> rowMapper = new ZaseleniyeRowMapper();
        List<Zaseleniye> list = jdbcTemplate.query(query, rowMapper, startDate, finalDate);
        return list;
    }

    @Override
    public Zaseleniye findById(int id) {
        String query = "SELECT * FROM hotel_iteration WHERE id = ?";
        RowMapper<Zaseleniye> rowMapper = new ZaseleniyeRowMapper();
        Zaseleniye zaseleniye = jdbcTemplate.queryForObject(query, rowMapper, id);
        return zaseleniye;
    }

    @Override
    public void add(Zaseleniye zaseleniye) {
        String query = "INSERT INTO hotel_iteration(id, start_date, final_date, user_id, room, iteration_type)" +
                " VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, zaseleniye.getId(), zaseleniye.getStart_date(), zaseleniye.getFinal_date(),
                zaseleniye.getUser_id(), zaseleniye.getRoom(), zaseleniye.getIteration_type());
    }

    @Override
    public void update(Zaseleniye zaseleniye) {
        String query = "UPDATE hotel_iteration SET start_date=?, final_date=?, user_id=?, room=?, iteration_type=? " +
                "WHERE id=?";
        jdbcTemplate.update(query, zaseleniye.getStart_date(), zaseleniye.getFinal_date(),
                zaseleniye.getUser_id(), zaseleniye.getRoom(), zaseleniye.getIteration_type(), zaseleniye.getId());
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM hotel_iteration WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}
