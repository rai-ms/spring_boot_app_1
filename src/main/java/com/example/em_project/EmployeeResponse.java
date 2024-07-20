package com.example.em_project;


public class EmployeeResponse {
    final String name;
    final String department;
    final Long id;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Long getId() {
        return id;
    }

    public EmployeeResponse(String name, String department, Long id) {
        this.name = name;
        this.department = department;
        this.id = id;
    }

}
