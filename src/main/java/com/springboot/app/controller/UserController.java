package com.springboot.app.controller;

import com.springboot.app.entity.UserEntity;
import com.springboot.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("users")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user){
        UserEntity savedUser = userService.createUser(user);
        return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);
    }
}
