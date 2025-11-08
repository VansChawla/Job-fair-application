package com.Hackathon.Project.JobFairApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobApplied {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation with Job
    @ManyToOne
    @JoinColumn(
            name = "job_id",
            referencedColumnName = "jobId",
            foreignKey = @ForeignKey(name = "fk_job_applied_job")
    )
    private Job job;

    // Relation with Applicant
    @ManyToOne
    @JoinColumn(
            name = "applicant_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_job_applied_applicant")
    )
    private Applicant applicant;

    private String status;
}
