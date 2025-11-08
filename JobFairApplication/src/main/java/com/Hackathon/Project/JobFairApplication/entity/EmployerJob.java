package com.Hackathon.Project.JobFairApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "employer_job")
public class EmployerJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(
            name = "employer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_employerjob_employer")
    )
    private Employer employer;

    @ManyToOne
    @JoinColumn(
            name = "job_id",                       // FK column name in this table
            referencedColumnName = "jobId",        // column in Job entity
            foreignKey = @ForeignKey(name = "fk_employerjob_job")       // FK constraint name
    )
    private Job job;

}
