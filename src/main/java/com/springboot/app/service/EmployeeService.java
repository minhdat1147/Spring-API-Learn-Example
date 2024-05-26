package com.springboot.app.service;

import com.springboot.app.entity.EmployeeEntity;
import com.springboot.app.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity saveEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(long id);
    List<EmployeeEntity> getAllEmployeeByName(String firstName, String lastName) throws ResourceNotFoundException;
    EmployeeEntity getEmployeeByEmail(String email) throws ResourceNotFoundException;
    EmployeeEntity updateEmployee(EmployeeEntity employee, long id) throws ResourceNotFoundException;
    EmployeeEntity updateEmployeeByEmail(EmployeeEntity employee, String email) throws ResourceNotFoundException;
    void deleteEmployee(long id) throws ResourceNotFoundException;
    void deleteEmployeeByEmail(String email) throws ResourceNotFoundException;
}
