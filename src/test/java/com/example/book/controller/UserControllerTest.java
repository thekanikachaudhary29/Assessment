package com.example.book.controller;

import com.example.book.dto.UserRequest;
import com.example.book.entity.User;
import com.example.book.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService service;


    @Test
    public void create() {
        User user = new User();
        UserRequest request = new UserRequest();
        request.setContactNumber(9L);
        request.setPassword("Ab");
        request.setEmail("k@gmail");
        request.setUserName("Kani");
        user.setUsername("Kanika");
        user.setPassword("Kan");
        user.setEmail("k@gmail.com");
        user.setContactNumber(941414L);
        Mockito.when(service.create(any())).thenReturn(user);
        ResponseEntity<User> response = userController.create(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Kanika", response.getBody().getUsername());
        assertEquals(1L, response.getBody().getId());
    }

}
