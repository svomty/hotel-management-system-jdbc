package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee findById(int id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(int id);
}
