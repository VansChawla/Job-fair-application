package com.Hackathon.Project.JobFairApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String website;

    @NotNull
    private String companyName;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String description;

    @NotNull
    private String location;
}
