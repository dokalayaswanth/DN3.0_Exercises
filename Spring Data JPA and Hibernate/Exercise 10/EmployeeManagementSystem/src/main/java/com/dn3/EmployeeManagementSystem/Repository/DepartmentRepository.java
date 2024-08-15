package com.dn3.EmployeeManagementSystem.Repository;

import com.dn3.EmployeeManagementSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new com.dn3.EmployeeManagementSystem.Repository.DepartmentDto(d.id, d.name) " +
           "FROM Department d WHERE d.name = :name")
    List<DepartmentDto> findDepartmentDtosByName(@Param("name") String name);
}
