package com.employee.management.service;

import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }
    public Optional<Employee> updateEmployee(Integer id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(existingEmployee -> {

            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());

            return employeeRepository.save(existingEmployee);
        });
    }
    public boolean deleteEmployee(Integer id) {
        if(!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);
        return true;
    }
}
