package com.example.book.service;

import com.example.book.entity.User;
import com.example.book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private SecurityConfig config;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return user; // your User entity should implement UserDetails
    }


//    public void login(@Valid LogInDto request) {
//        User user = userRepository.findByUsername(login.getUsername())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        if (!config.passwordEncoder().matches(login.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid Password");
//        }
//        String token = jwtUtil.generateToken(user.getUsername());
//        return ResponseEntity.ok(new JwtResponse(token)
//    }
}
