package com.example.dz28;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ch.qos.logback.core.util.AggregationType.NOT_FOUND;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        if (!validateInput(firstName,lastName)) {
            throw new InvalidInputException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAdded();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (!validateInput(firstName, lastName)){
            throw new InvalidInputException();
        }
        Employee employee = find(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (!validateInput(firstName, lastName)){
            throw new InvalidInputException();
        }
        final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findAny();
        return employee.orElseThrow(() -> new EmployeeNotFound(String.valueOf(NOT_FOUND)));
    }

    @Override
    public Employee getMaxSalary(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFound(String.valueOf(NOT_FOUND)));
    }

    @Override
    public Employee getMinSalary(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFound(String.valueOf(NOT_FOUND)));
    }

    @Override
    public List<Employee> EmployeesByOneDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> EmployeesByDepartments() {
        return Collections.unmodifiableList(employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()));
    }

    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public List<Employee> fillEmployeesList() {
        employees.add(new Employee("Петр", "Пирогов", 55_000, 1));
        employees.add(new Employee("Василий", "Земсков", 38_000, 3));
        employees.add(new Employee("Полина", "Каримова", 40_000, 5));
        return employees;
    }
    private boolean validateInput(String firstName, String lastName){
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }

}
