package com.Hackathon.Project.JobFairApplication.service;

import com.Hackathon.Project.JobFairApplication.dto.UserDTO;
import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.Employer;

public interface ApplicantService {
    public Applicant findByEmailAndPassword(String username,String password);
    public void addNewApplicant( UserDTO applicant);
    public Applicant getDetails( Long id);
    public boolean isProfileAvailable(String email);
}
