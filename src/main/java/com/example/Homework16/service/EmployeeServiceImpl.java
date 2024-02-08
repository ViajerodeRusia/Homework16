package com.example.Homework16.service;

import com.example.Homework16.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final List<Employee> employees = new ArrayList<>();

    @Override
    public String addEmployee(String name, String surname, Integer department, Integer salary) {
        if(employees.stream().noneMatch(e -> e.getName().equals(name) && e.getSurname().equals(surname))) {
            employees.add(new Employee(name, surname, department, salary));
            return "success";
        }
        return "duplicate";
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}

