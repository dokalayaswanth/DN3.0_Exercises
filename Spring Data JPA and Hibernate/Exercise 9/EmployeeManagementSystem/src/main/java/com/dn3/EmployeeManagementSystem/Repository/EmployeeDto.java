package com.dn3.EmployeeManagementSystem.Repository;

public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeDto(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

}
