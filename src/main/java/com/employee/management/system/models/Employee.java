package com.employee.management.system.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    private int empId;
    private String firstName ;
    private String lastName;
    private String email ;
    private String department; 
    private String contactNo;

    public Employee() {

    }

    // constructor to initialize the variables created
    public Employee(int empId, String firstName, String lastName, String email, String department, String contactNo) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.contactNo = contactNo;
    }

    @Id
    @GeneratedValue
    public int getEmployeeId() {
        return empId;
    }

    public void setEmployeeId(int empId) {
        this.empId = empId;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;

    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContact() {
        return contactNo;
    }

    public void setContact(String contactNo) {
        this.contactNo = contactNo;
    }

}
