package com.example.Application.service;
import com.example.Application.entity.User;
import com.example.Application.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class user_service {
    @Autowired
    private userrepository userRepository;


    public User register(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
    public Optional<User> login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
