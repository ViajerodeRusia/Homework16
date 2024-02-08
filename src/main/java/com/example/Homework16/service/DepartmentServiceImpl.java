package com.example.Homework16.service;

import com.example.Homework16.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee getEmployeeWithMinSalaryDep(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    @Override
    public Employee getEmployeeWithMaxSalaryDep(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    @Override
    public Integer getCostsAllEmployees() {
        Integer sum = employeeService.getAllEmployees().stream()
                .mapToInt(Employee::getSalary)
                .sum();
        return sum;
    }

    @Override
    public Integer getCostsAllEmployeesDep(Integer department) {
        Integer sum = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToInt(Employee::getSalary)
                .sum();
        return sum;
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getAllEmployees().stream()
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getAllEmployees().stream()
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    @Override
    public List<Employee> getAllEmployeesOfDepartment(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}
