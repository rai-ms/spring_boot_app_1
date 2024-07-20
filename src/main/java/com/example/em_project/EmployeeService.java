package com.example.em_project;

import java.util.List;


public interface EmployeeService {

    Employee createEmployee(EmployeeResponse employee);
    List<Employee> getEmployees();
    Employee getEmployee(Long id);
    boolean deleteEmployee(Long id);
    Employee updateEmployee(Long id, Employee employee);
}
