package com.spring.demo.FirstSpringApp.controller;

import com.spring.demo.FirstSpringApp.dto.EmployeeDto;
import com.spring.demo.FirstSpringApp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createOne(@RequestBody EmployeeDto employeeDto){

        EmployeeDto created = employeeService.createOne(employeeDto);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getByID(@PathVariable("id") String id){

        EmployeeDto employee = employeeService.getByID(id);

        return  ResponseEntity.ok(employee);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAll(){

        List<EmployeeDto> employees = employeeService.getAll();

        return  ResponseEntity.ok(employees);
    }


    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateByID(@PathVariable("id") String id, @RequestBody EmployeeDto newEmployee){

        EmployeeDto employee = employeeService.updateByID(id,newEmployee);

        return  ResponseEntity.ok(employee);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") String id){

        employeeService.deleteByID(id);

        return  ResponseEntity.ok("Employee deleted successfully");
    }
}
