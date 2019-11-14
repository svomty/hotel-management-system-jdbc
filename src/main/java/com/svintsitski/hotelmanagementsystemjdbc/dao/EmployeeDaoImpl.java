package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAll() {
        String query = "SELECT * from employees";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        List<Employee> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    @Override
    public Employee findById(int id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        Employee employee = jdbcTemplate.queryForObject(query, rowMapper, id);
        System.out.println(employee.toString());
        return employee;
    }

    @Override
    public void add(Employee employee) {
        String query = "INSERT INTO employees(id, фамилия, имя, отчество, пол, телефон, адрес, номер_паспорта) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), employee.getPatronymic(), employee.getGender(), employee.getPhone(), employee.getAddress(), employee.getPassportId());

    }

    @Override
    public void update(Employee employee) {
        String query = "UPDATE employees SET фамилия=?, имя=?, отчество=?, пол=?, телефон=?, адрес=?, номер_паспорта=? WHERE id=?";
        jdbcTemplate.update(query, employee.getLastName(), employee.getFirstName(), employee.getPatronymic(), employee.getGender(), employee.getPhone(), employee.getAddress(), employee.getPassportId(), employee.getEmployeeId());

    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM employees WHERE id=?";
        jdbcTemplate.update(query, id);
    }

}
