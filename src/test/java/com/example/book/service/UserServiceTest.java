package com.example.book.service;

import com.example.book.dto.UserRequest;
import com.example.book.entity.User;
import com.example.book.repository.UserRepository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    public void createTest() {
        UserRequest request = new UserRequest();
        request.setUserName("KAN");
        request.setPassword("AS");
        request.setEmail("k@gmail.com");
        request.setContactNumber(9282772L);
        User user = new User();
        user.setUsername("KAN");
        user.setPassword("AS");
        user.setEmail("k@gmail.com");
        user.setContactNumber(9282772L);
        user.setRole("LIB");
        user.setId(2L);
        Mockito.when(repository.save(any())).thenReturn(user);
        User response = service.create(request);
        assertNotNull(response);
        assertEquals("KAN",response.getUsername());
        assertEquals(2L, response.getId());
    }
}
