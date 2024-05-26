package com.springboot.app.service.impl;

import com.springboot.app.entity.EmployeeEntity;
import com.springboot.app.exception.ResourceNotFoundException;
import com.springboot.app.repository.EmployeeRepository;
import com.springboot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResolutionException("Employee not found by ::"+id));

    }

    @Override
    public List<EmployeeEntity> getAllEmployeeByName(String firstName, String lastName) throws ResourceNotFoundException {
         List<EmployeeEntity> employees=employeeRepository.findAllByFirstNameAndLastName(firstName, lastName);
         if(employees == null){
             throw  new ResourceNotFoundException("Employee not found with the given names");
         }
         return employees;
    }

    @Override
    public EmployeeEntity getEmployeeByEmail(String email) throws ResourceNotFoundException {
        EmployeeEntity employee = employeeRepository.findByEmail(email);
        if (employee == null){
            throw  new ResourceNotFoundException("Employee not found with email address");
        }
        return employee;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employee, long id) throws ResourceNotFoundException {
        EmployeeEntity existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists in data Employee table by id =:: "+id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public EmployeeEntity updateEmployeeByEmail(EmployeeEntity employee, String email) throws ResourceNotFoundException {
        EmployeeEntity existingEmployee = employeeRepository.findByEmail(email);
        if(existingEmployee == null){
            throw  new ResourceNotFoundException(" Employee not exists in Employee table by email = ::"+email);
        }
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
    @Override
    public void deleteEmployee(long id) throws ResourceNotFoundException {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exists in data Employee table by id =:: "+id));
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteEmployeeByEmail(String email) throws ResourceNotFoundException {
        EmployeeEntity existingEmployee = employeeRepository.findByEmail(email);
        if(existingEmployee == null){
            throw  new ResourceNotFoundException(" Employee not exists in Employee table by email = ::"+email);
        }
        employeeRepository.deleteByEmail(email);
    }
}
