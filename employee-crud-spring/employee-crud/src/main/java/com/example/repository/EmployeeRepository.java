package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void deleteById(int id);
}
