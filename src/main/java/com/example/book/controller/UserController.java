package com.example.book.controller;

import com.example.book.dto.UserRequest;
import com.example.book.entity.User;
import com.example.book.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create/credentials")
    public ResponseEntity<User> create(@RequestBody @Valid UserRequest request) {
       User user = service.create(request);
       return new  ResponseEntity<>(user,HttpStatus.OK);
    }
}