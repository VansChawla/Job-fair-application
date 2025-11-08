package com.Hackathon.Project.JobFairApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobId")
    private Long id;


    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String location;

    @NotNull
    private String eligibility;

    @NotNull
    private Long salary;

    @NotNull
    private String companyName;

    @NotNull
    private boolean isAvailable=true;

}
