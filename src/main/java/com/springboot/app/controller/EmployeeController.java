package com.springboot.app.controller;
import com.springboot.app.entity.EmployeeEntity;
import com.springboot.app.exception.ResourceNotFoundException;
import com.springboot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee){
        return new ResponseEntity<EmployeeEntity>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<EmployeeEntity>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @GetMapping("/getEmail/{email}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("email") String email) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/getName")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeById(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeService.getAllEmployeeByName(firstName,lastName), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody EmployeeEntity employee) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @PutMapping("/updateByEmail")
    public ResponseEntity<EmployeeEntity> updateEmployeeByEmail(@RequestParam("email") String email,
                                                                @RequestBody EmployeeEntity employee) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeService.updateEmployeeByEmail(employee,email), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) throws ResourceNotFoundException {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully!.", HttpStatus.OK);

     }
    @DeleteMapping("/deleleByEmail")
    public ResponseEntity<String> deleteEmployee(@RequestParam("email") String email) throws ResourceNotFoundException {
        employeeService.deleteEmployeeByEmail(email);
        return new ResponseEntity<>("Employee deleted successfully!.", HttpStatus.OK);

    }



}
