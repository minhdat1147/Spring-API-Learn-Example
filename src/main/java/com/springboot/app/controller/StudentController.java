package com.springboot.app.controller;

import com.springboot.app.entity.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student")
    public StudentEntity getStudent(){
        return new StudentEntity("Thai Minh", "Dat");
    }
}
