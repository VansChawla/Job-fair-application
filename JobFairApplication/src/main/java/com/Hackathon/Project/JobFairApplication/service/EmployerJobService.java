package com.Hackathon.Project.JobFairApplication.service;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.EmployerJob;

import java.util.List;

public interface EmployerJobService {
    public void addToEmployerJobTable(Long jobId,Long comId);

}
