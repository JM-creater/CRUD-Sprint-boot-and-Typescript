package com.Springpro.Springpro.repository;

import com.Springpro.Springpro.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Number> {

}
