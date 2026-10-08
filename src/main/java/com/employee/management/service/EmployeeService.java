package com.employee.management.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public String getEmployees() {
        return "Employee data from service layer";
    }
}
