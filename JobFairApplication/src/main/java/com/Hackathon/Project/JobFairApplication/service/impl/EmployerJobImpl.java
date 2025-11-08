package com.Hackathon.Project.JobFairApplication.service.impl;

import com.Hackathon.Project.JobFairApplication.dto.EmployerJobDTO;
import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.EmployerJob;
import com.Hackathon.Project.JobFairApplication.entity.Job;
import com.Hackathon.Project.JobFairApplication.entity.JobApplied;
import com.Hackathon.Project.JobFairApplication.repository.*;
import com.Hackathon.Project.JobFairApplication.service.EmployerJobService;
import com.Hackathon.Project.JobFairApplication.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerJobImpl implements EmployerJobService {

    private final EmployerJobRepo employerJobRepo;
    private final EmployerRepo employerRepo;
    private final JobRepo jobRepo;
    private final ModelMapper modelMapper;
    private final ApplicantRepo applicantRepo;
    private final JobAppliedRepo jobAppliedRepo;

    @Override
    public void addToEmployerJobTable ( Long jobId, Long comId ) {

        EmployerJobDTO employerJobDTO=new EmployerJobDTO(employerRepo.getReferenceById (comId),jobRepo.getReferenceById (jobId));
        EmployerJob employerJob=modelMapper.map(employerJobDTO,EmployerJob.class);
        employerJobRepo.save (employerJob);
    }

    public List<Applicant> getAllJobList( Long comId){

        // Find all EmployerJob records by employer (company) ID
        List<EmployerJob> employerJobs = employerJobRepo.findByEmployerId(comId);

        // List to hold all applicants
        List<Applicant> applicants = new ArrayList<>();

        // Iterate over the EmployerJobs to get the associated Jobs
        for (EmployerJob employerJob : employerJobs) {
            Job job = employerJob.getJob();  // Extract the Job from the EmployerJob

            // Fetch the applicants for this job (assuming there's a method in JobAppliedRepo)
            List<JobApplied> jobApplicants = jobAppliedRepo.findByJobId(job.getId());

            // Extract the applicants from JobApplied entities and add them to the list
            for (JobApplied jobApplied : jobApplicants) {
                applicants.add(jobApplied.getApplicant());  // Add the associated Applicant
            }
        }

        // Return the list of applicants
        return applicants;
    }


}
