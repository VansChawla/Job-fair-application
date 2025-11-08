package com.Hackathon.Project.JobFairApplication.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApplicantDTO {

    private String username;

    private String password;

    private String skill1;
    private String skill2;
    private String skill3;
    private String skill4;
    private String skill5;

    private String email;

    private String phone;

    private String resumeLink;
}
