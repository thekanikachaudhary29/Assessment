package com.example.book.authcontroller;

import com.example.book.config.SecurityConfig;
import com.example.book.dto.JwtResponse;
import com.example.book.dto.LogInDto;
import com.example.book.dto.UserRequest;
import com.example.book.entity.User;
import com.example.book.repository.UserRepository;
import com.example.book.service.AuthService;
import com.example.book.service.JwtService;
import com.example.book.service.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SecurityConfig config;

    @Autowired
    private AuthService authService;

    private final AuthenticationManager authenticationManager;


    private final JwtService jwtService;  // service to generate JWT
   // private final AuthService auth;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          AuthService auth) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.authService = auth;
    }

    //register
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserRequest request) {
        User user = new User();
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setContactNumber(request.getContactNumber());
        return ResponseEntity.ok(userRepository.save(user));
    }

    //login
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> logIn(@RequestBody @Valid LogInDto request) {
        // authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                )
        );

        // if authentication passed, generate token
        UserDetails userDetails = authService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}