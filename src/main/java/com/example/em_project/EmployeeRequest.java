package com.example.em_project;

import lombok.Getter;

@Getter
public class EmployeeRequest {
    private String name;
    private String department;

    public EmployeeRequest(String department, String name) {
        this.department = department;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
