package com.bookstore.controller;

import com.bookstore.dto.*;
import com.bookstore.security.JwtUtil;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody AuthRequest req) {
        userService.registerUser(req.username, req.password, "ROLE_USER");
        return "User created!";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.username, req.password));
        String token = jwtUtil.generateToken(req.username);
        return new AuthResponse();
    }
}
