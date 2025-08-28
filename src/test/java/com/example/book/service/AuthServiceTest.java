package com.example.book.service;

import com.example.book.entity.User;
import com.example.book.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void loadUserByUsernameTest() {
        User user = new User();
        user.setUsername("KAN");
        user.setPassword("AS");
        user.setEmail("k@gmail.com");
        user.setContactNumber(9282772L);
        user.setRole("LIB");
        user.setId(2L);
        Mockito.when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        UserDetails response = authService.loadUserByUsername("Kanika");
        assertNotNull(response);
        assertEquals("KAN", response.getUsername());
    }
}
