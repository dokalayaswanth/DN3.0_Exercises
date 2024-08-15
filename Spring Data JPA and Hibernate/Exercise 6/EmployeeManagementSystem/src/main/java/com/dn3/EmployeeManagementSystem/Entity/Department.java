package com.dn3.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
@NamedQueries({
    @NamedQuery(name = "Department.findByName",
                query = "SELECT d FROM Department d WHERE d.name = :name")
})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
