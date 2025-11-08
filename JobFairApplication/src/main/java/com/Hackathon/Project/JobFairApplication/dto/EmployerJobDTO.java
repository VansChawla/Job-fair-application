package com.Hackathon.Project.JobFairApplication.dto;

import com.Hackathon.Project.JobFairApplication.entity.Employer;
import com.Hackathon.Project.JobFairApplication.entity.Job;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployerJobDTO {


    private Employer employer;

    private Job job;

}
