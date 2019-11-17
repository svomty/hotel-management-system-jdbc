package com.svintsitski.hotelmanagementsystemjdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZaseleniyeRowMapper implements RowMapper<Zaseleniye> {
    @Override
    public Zaseleniye mapRow(ResultSet resultSet, int i) throws SQLException {
        Zaseleniye zaseleniye = new Zaseleniye();
        zaseleniye.setId(resultSet.getInt("id"));
        zaseleniye.setStart_date(resultSet.getDate("start_date"));
        zaseleniye.setFinal_date(resultSet.getDate("final_date"));
        zaseleniye.setUser_id(resultSet.getInt("user_id"));
        zaseleniye.setRoom(resultSet.getInt("room"));
        zaseleniye.setIteration_type(resultSet.getString("iteration_type"));
        return zaseleniye;
    }
}
