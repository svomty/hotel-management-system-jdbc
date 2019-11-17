package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll();

    Employee findById(int id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(int id);
}
