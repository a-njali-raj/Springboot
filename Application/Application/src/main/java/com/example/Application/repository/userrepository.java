package com.example.Application.repository;

import com.example.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userrepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
    public User findByResetPasswordToken(String token);


}
