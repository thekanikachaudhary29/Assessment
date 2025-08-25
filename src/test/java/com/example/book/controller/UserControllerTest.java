package com.example.book.controller;

import com.example.book.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @MockitoBean
    private UserService service;

}
