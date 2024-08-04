package com.Springpro.Springpro.service;

import com.Springpro.Springpro.Employee;
import com.Springpro.Springpro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public Employee updateEmployeeById(int id, Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee1.get().getName()) && !"".equalsIgnoreCase(employee1.get().getName())) {
                originalEmployee.setName(employee1.get().getName());
            }
            if (Objects.nonNull(employee1.get().getAddress()) && !"".equalsIgnoreCase(employee1.get().getAddress())) {
                originalEmployee.setAddress(employee1.get().getAddress());
            }
            if (Objects.nonNull(employee1.get().getSalary()) && employee1.get().getSalary() != 0) {
                originalEmployee.setSalary(employee1.get().getSalary());
            }
            return employeeRepository.save(originalEmployee);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }

}
