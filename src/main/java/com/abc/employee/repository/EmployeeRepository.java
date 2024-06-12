package com.abc.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
