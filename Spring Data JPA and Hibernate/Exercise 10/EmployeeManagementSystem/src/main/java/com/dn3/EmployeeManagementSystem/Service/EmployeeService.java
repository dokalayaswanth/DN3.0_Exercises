package com.dn3.EmployeeManagementSystem.Service;

import com.dn3.EmployeeManagementSystem.Entity.Employee;
import com.dn3.EmployeeManagementSystem.Repository.EmployeeRepository;

import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;

import org.hibernate.boot.model.internal.EntityBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @PersistenceUnit
    private EntityBinder entityManager;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null; // Or throw an exception
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void saveEmployees(List<Employee> employees) {
        int batchSize = 30;
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                ((JpaRepository<Employee, Long>) entityManager).flush();
                ((List<Employee>) entityManager).clear();
            }
        }
    }
}
