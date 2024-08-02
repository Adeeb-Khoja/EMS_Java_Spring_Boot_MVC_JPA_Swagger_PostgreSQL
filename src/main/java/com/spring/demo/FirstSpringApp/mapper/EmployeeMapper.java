package com.spring.demo.FirstSpringApp.mapper;

import com.spring.demo.FirstSpringApp.dto.EmployeeDto;
import com.spring.demo.FirstSpringApp.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee e){
        return new EmployeeDto(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto e){
        return new Employee(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }
}
