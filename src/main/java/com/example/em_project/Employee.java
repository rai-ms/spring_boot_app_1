package com.example.em_project;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity()
@Table(name = "emp_db")
@NoArgsConstructor
public class Employee {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
