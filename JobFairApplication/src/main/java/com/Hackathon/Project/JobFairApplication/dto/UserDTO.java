package com.Hackathon.Project.JobFairApplication.dto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserDTO {
    private String email;
    private String phone;
    private String password;
    private String role; // "candidate" or "company"

    // Applicant-specific fields
    private String username;
    private String resumeLink;
    private String skill1;
    private String skill2;
    private String skill3;
    private String skill4;
    private String skill5; // List of skills (top 5)

    // Employer-specific fields
    private String companyName;
    private String website;
    private String description;
    private String location;


}

