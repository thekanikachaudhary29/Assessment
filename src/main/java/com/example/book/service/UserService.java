package com.example.book.service;

import com.example.book.dto.UserRequest;
import com.example.book.entity.User;
import com.example.book.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(@Valid UserRequest request) {
        User user = new User();
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setContactNumber(request.getContactNumber());
        User users = repository.save(user);
        return users;
    }
}