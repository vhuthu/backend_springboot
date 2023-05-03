package com.employee.management.system.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.system.models.Employee;
import com.employee.management.system.repo.EmployeeRepo;

@CrossOrigin(origins = "http://localhost:4200/") 
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Employee> findOne(Employee employee){
        return employeeRepo.findById(employee.getEmployeeId());
    }

    @PostMapping
    public Employee save(@Validated @NonNull @RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @PutMapping(value = "/{empId}")
    public ResponseEntity<String> update(@PathVariable int empId,@Validated @NonNull @RequestBody Employee employee) {
        Employee currentEmployee = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee with id " + empId + " cannot be found"));
        currentEmployee.setFirstname(employee.getFirstname());
        currentEmployee.setContact(employee.getContact());
        currentEmployee.setDepartment(employee.getDepartment());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setLastname(employee.getLastname());
        employeeRepo.save(currentEmployee);
        return new ResponseEntity<String>("Employee updated successfully", HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        employeeRepo.deleteById(id);
    }

    @DeleteMapping(value = "/employee")
    public void delete(@Validated @NonNull @RequestBody Employee employee){
        employeeRepo.deleteAll();
    }

   
}
 

