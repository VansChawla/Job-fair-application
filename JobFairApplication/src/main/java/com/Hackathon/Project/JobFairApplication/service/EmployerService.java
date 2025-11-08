package com.Hackathon.Project.JobFairApplication.service;

import com.Hackathon.Project.JobFairApplication.dto.UserDTO;
import com.Hackathon.Project.JobFairApplication.entity.Employer;

public interface EmployerService {
    public Employer findByEmailAndPassword ( String email, String password );

    public void addNewEmployee ( UserDTO employerDto );

    public Employer getDetails( Long id);
    public boolean isProfileAvailable(String email);
}
