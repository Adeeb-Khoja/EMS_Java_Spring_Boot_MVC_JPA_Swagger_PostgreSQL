package com.spring.demo.FirstSpringApp.service;

import com.spring.demo.FirstSpringApp.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto getByID(String id);
    List<EmployeeDto> getAll();
    EmployeeDto createOne(EmployeeDto employee);
    EmployeeDto updateByID(String id, EmployeeDto employee);
    void deleteByID(String id);

}
