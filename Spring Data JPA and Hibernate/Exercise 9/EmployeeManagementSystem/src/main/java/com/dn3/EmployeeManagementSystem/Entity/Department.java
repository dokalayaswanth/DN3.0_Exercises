package com.dn3.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
