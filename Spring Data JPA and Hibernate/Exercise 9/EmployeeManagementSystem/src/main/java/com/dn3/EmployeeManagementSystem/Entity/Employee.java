package com.dn3.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
