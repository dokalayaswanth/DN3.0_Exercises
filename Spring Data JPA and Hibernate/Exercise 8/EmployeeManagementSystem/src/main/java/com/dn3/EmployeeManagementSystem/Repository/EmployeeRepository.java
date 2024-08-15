package com.dn3.EmployeeManagementSystem.Repository;

import com.dn3.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<EmployeeProjection> findByDepartmentName(String departmentName, Pageable pageable);

    @Query("SELECT new com.dn3.EmployeeManagementSystem.Repository.EmployeeDto(e.id, e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d WHERE e.department.name = :departmentName")
    Page<EmployeeDto> findEmployeeDtosByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    Employee findByEmail(String email);
}
