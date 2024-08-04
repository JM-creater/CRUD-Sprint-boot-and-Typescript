package com.Springpro.Springpro.service;

import com.Springpro.Springpro.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(int id);

    Employee updateEmployeeById(int id, Employee employee);

    String deleteDepartmentById(int id);

}
