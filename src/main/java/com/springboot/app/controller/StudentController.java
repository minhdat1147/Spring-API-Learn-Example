package com.springboot.app.controller;

import com.springboot.app.entity.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student/{firstName}/{lastName}")
    public StudentEntity getStudent(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return new StudentEntity(firstName, lastName);
    }
}
