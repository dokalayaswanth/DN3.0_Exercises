package com.dn3.EmployeeManagementSystem.Controller;

import com.dn3.EmployeeManagementSystem.Entity.Department;
import com.dn3.EmployeeManagementSystem.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable String name) {
        return departmentRepository.findDepartmentsByName(name);
    }
}
