package com.example.Homework16.controller;

import com.example.Homework16.domain.Employee;
import com.example.Homework16.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(@Autowired DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(path = "/filter")
    public String getAllEmployees(@RequestParam Integer department, Model model){
        List<Employee> employeesOfDepartment = departmentService.getAllEmployeesOfDepartment(department);
        model.addAttribute("employeesOfDepartment", employeesOfDepartment);
        model.addAttribute("department", department);

        Employee maxSalaryDep = departmentService.getEmployeeWithMaxSalaryDep(department);
        Employee minSalaryDep = departmentService.getEmployeeWithMinSalaryDep(department);
        model.addAttribute("maxSalaryDep", maxSalaryDep != null ? maxSalaryDep.getSalary() : 0);
        model.addAttribute("minSalaryDep", minSalaryDep != null ? minSalaryDep.getSalary() : 0);

        Integer allCostsDep = departmentService.getCostsAllEmployeesDep(department);
        model.addAttribute("allCostsDep", allCostsDep != null ? allCostsDep : 0);
        return "byDepartment";
    }
}
