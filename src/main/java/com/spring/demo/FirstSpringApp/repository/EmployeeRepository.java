package com.spring.demo.FirstSpringApp.repository;

import com.spring.demo.FirstSpringApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
