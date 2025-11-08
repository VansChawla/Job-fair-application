package com.Hackathon.Project.JobFairApplication.service.impl;

import com.Hackathon.Project.JobFairApplication.dto.JobAppliedDTO;
import com.Hackathon.Project.JobFairApplication.dto.JobDTO;
import com.Hackathon.Project.JobFairApplication.entity.*;
import com.Hackathon.Project.JobFairApplication.repository.ApplicantRepo;
import com.Hackathon.Project.JobFairApplication.repository.EmployerJobRepo;
import com.Hackathon.Project.JobFairApplication.repository.JobAppliedRepo;
import com.Hackathon.Project.JobFairApplication.repository.JobRepo;
import com.Hackathon.Project.JobFairApplication.service.EmployerJobService;
import com.Hackathon.Project.JobFairApplication.service.JobAppliedService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAppliedImpl implements JobAppliedService {

    private final JobAppliedRepo jobAppliedRepo;
    private final JobRepo jobRepo;
    private final ApplicantRepo applicantRepo;
    private final ModelMapper modelMapper;


    @Override
    public void applyForJob ( Long jobId,Long apId ) {
        Job job=jobRepo.getReferenceById (jobId);
        job.setAvailable (false);
        Applicant applicant= applicantRepo.getReferenceById (apId);
        JobAppliedDTO jobDTO=new JobAppliedDTO (job,applicant);
        System.out.println (jobDTO.getJob());
        jobAppliedRepo.save(modelMapper.map(jobDTO, JobApplied.class));
    }

}
