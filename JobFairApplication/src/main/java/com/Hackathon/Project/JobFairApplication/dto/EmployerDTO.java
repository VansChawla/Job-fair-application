package com.Hackathon.Project.JobFairApplication.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployerDTO {

    private String company_name;

    private String password;

    private String email;

    private String description;

    private String location;
}
