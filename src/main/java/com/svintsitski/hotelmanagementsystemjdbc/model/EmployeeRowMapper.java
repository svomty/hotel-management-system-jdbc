package com.svintsitski.hotelmanagementsystemjdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("id"));
        employee.setFirstName(rs.getString("имя"));
        employee.setLastName(rs.getString("фамилия"));
        employee.setPatronymic(rs.getString("отчество"));
        employee.setGender(rs.getString("пол"));
        employee.setPhone(rs.getInt("телефон"));
        employee.setAddress(rs.getString("адрес"));
        employee.setPassportId(rs.getString("номер_паспорта"));
        employee.setPassword(rs.getString("password"));
        return employee;
    }

}
