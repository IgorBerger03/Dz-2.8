package com.example.dz28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Object addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "salary") int salary,
            @RequestParam(value = "department") int department) {
                Employee employee = null;
        try {
            employee = employeeService.add(firstName, lastName, salary, department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping("/remove")
    public Object removeEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.remove(firstName, lastName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping("/find")
    public Object findEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.find(firstName, lastName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/departments/max-salary")
    public Object getMaxEmployeeSalary(
            @RequestParam(value = "departmentId") int departmentId) {
        Employee employee = null;
        try {
            employee = employeeService.getMaxSalary(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/departments/min-salary")
    public Object getMinEmployeeSalary(
            @RequestParam(value = "departmentId") int departmentId) {
        Employee employee = null;
        try {
            employee = employeeService.getMinSalary(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/departments/all-by-one-department")
    public Object getEmployeesByOneDepartment(
            @RequestParam(value = "departmentId") int departmentId) {
        List<Employee> employees = null;
        try {
            employees = employeeService.EmployeesByOneDepartment(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }
    @GetMapping(path = "/departments/all-by-departments")
    public Object getEmployeesByDepartments() {
        List<Employee> employees = null;
        try {
            employees = employeeService.EmployeesByDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }
    @GetMapping(path = "/print")
    public Object getEmployees() {
        List<Employee> employees = null;
        try {
            employees = employeeService.printEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }
    @GetMapping(path = "/fill")
    public Object fillList() {
        List<Employee> employees = null;
        try {
            employees = employeeService.fillEmployeesList();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }
}
