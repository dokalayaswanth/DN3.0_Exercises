package com.dn3.EmployeeManagementSystem.Controller;

import com.dn3.EmployeeManagementSystem.Entity.Employee;
import com.dn3.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.dn3.EmployeeManagementSystem.Repository.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/department/{departmentName}")
    public Page<EmployeeDto> getEmployeesByDepartment(
            @PathVariable String departmentName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return employeeRepository.findEmployeeDtosByDepartmentName(departmentName, pageable);
    }

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        return employeeRepository.findByEmail(email);
    }
}
