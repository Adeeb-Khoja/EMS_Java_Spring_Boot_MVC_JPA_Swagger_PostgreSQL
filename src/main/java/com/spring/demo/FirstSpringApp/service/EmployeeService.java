package com.spring.demo.FirstSpringApp.service;

import com.spring.demo.FirstSpringApp.dto.EmployeeDto;
import com.spring.demo.FirstSpringApp.entity.Employee;
import com.spring.demo.FirstSpringApp.exception.NotFoundException;
import com.spring.demo.FirstSpringApp.mapper.EmployeeMapper;
import com.spring.demo.FirstSpringApp.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeService implements  IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto getByID(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("No such employee with this id" + id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto createOne(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saved);
    }

    @Override
    public EmployeeDto updateByID(String id ,EmployeeDto newEmployee) {

        Employee employeeFromDb = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("No such employee with this id" + id));

        employeeFromDb.setFirstName(newEmployee.getFirstName());
        employeeFromDb.setLastName(newEmployee.getLastName());
        employeeFromDb.setEmail(newEmployee.getEmail());

        Employee updated = employeeRepository.save(employeeFromDb);
        return EmployeeMapper.mapToEmployeeDto(updated);
    }

    @Override
    public void deleteByID(String id) {

        Employee employeeFromDb = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("No such employee with this id" + id));

        employeeRepository.deleteById(id);

    }
}
