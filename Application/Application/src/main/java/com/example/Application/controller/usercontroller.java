package com.example.Application.controller;

import com.example.Application.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class usercontroller {

    @Autowired
    private com.example.Application.service.user_service user_service;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = user_service.register(user);
            return ResponseEntity.ok("Successfully created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = user_service.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> existingUser = user_service.login(user.getEmail(), user.getPassword());

        if (existingUser.isPresent()) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
