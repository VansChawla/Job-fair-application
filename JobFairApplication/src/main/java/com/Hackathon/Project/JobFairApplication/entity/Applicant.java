package com.Hackathon.Project.JobFairApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, message = "Username must be at least 2 characters long")
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    private String email;


    private String skill1;
    private String skill2;
    private String skill3;
    private String skill4;
    private String skill5;

    @NotNull
    private String phone;

    @NotNull
    private String resumeLink;
}
