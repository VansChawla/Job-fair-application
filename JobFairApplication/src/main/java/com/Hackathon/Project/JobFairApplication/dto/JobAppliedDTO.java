package com.Hackathon.Project.JobFairApplication.dto;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.Employer;
import com.Hackathon.Project.JobFairApplication.entity.Job;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JobAppliedDTO {
    private Job job;


    private Applicant applicant;
}
