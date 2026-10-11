package com.employee.management.controller;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {

        return employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                        "Employee Not found with id: " + id
                ));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Integer id,
            @RequestBody Employee updatedEmployee) {

        return employeeService.updateEmployee(id, updatedEmployee)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found with id: " + id
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        boolean deleted = employeeService.deleteEmployee(id);

        if(!deleted) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Employee not found with id: " + id
            );
        }
        return ResponseEntity.noContent().build();
    }

}
