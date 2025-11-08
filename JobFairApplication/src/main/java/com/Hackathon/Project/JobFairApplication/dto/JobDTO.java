package com.Hackathon.Project.JobFairApplication.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDTO {
    private String title;

    private String companyName;

    private String description;

    private String location;

    private String eligibility;

    private Long salary;

}
