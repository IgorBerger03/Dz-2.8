package com.example.dz28;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int department);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Employee getMaxSalary(int department);
    Employee getMinSalary(int department);
    List<Employee> EmployeesByOneDepartment(int department);
    List<Employee> EmployeesByDepartments();
    List<Employee> printEmployees();
    List<Employee> fillEmployeesList();
}
