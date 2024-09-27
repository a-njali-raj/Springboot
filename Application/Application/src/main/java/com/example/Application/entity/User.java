package com.example.Application.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Data;
import java.util.Date;
@Data

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String fname;
    private String lname;
    @Column(unique=true,nullable = false)
    private String email;
    @Column(unique=true,nullable = false)
    private String phonenumber;
    private LocalDate dob;
    private String addressLine;
    private String city;
    private String state;
    private String postalCode;
    private String gradeOrYearLevel;
    private double gpaScore;
    private double gwaPercentile;
    private LocalDate expectedGraduationDate;
    private String schoolName;
    private String department;
    @Column(nullable = false)
    private String password;
    private String resetPasswordToken;


}
