package com.employee.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private int age;
    private double salary;
    private String department;

    // Required by JPA
    public Employee() {

    }

    public Employee(Integer id, String name, int age, double salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public double getSalary() {
        return this.salary;
    }
    public String getDepartment() {
        return this.department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
