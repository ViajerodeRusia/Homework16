package com.example.Homework16.service;

import com.example.Homework16.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DepartmentService {
    Integer getCostsAllEmployees();
    Integer getCostsAllEmployeesDep(Integer department);
    Employee getEmployeeWithMinSalary();
    Employee getEmployeeWithMaxSalary();
    Employee getEmployeeWithMinSalaryDep(Integer department);
    Employee getEmployeeWithMaxSalaryDep(Integer department);
    List<Employee> getAllEmployeesOfDepartment(Integer department);
}
