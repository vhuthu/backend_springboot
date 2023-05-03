package com.employee.management.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management.system.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    
}
