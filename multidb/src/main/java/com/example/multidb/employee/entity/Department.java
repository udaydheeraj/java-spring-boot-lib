package com.example.multidb.employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int departmentId;

    @Column(name="department_name")
    private String departmentName;


    private String location;
}
