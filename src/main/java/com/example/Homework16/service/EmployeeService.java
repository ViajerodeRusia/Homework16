package com.example.Homework16.service;

import com.example.Homework16.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    String addEmployee(String name, String surname, Integer department, Integer salary);

}
