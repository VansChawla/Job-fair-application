package com.Hackathon.Project.JobFairApplication.service.impl;

import com.Hackathon.Project.JobFairApplication.dto.JobDTO;
import com.Hackathon.Project.JobFairApplication.entity.Job;
import com.Hackathon.Project.JobFairApplication.repository.EmployerJobRepo;
import com.Hackathon.Project.JobFairApplication.repository.JobRepo;
import com.Hackathon.Project.JobFairApplication.service.JobService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobImpl implements JobService {

    private final  ModelMapper modelMapper;
    private final JobRepo jobRepo;
    private final EmployerJobImpl employerJob;

    public void saveNewJob( JobDTO jobDTO , Long comId){
        Job jobNew =modelMapper.map ( jobDTO, Job.class);
        jobRepo.save ( jobNew );
        employerJob.addToEmployerJobTable (jobNew.getId(), comId);

    }

    @Override
    public List<Job> getAllJobsList () {
        return jobRepo.findAll();
    }


    public List<Job> searchJobsByTitle(String title) {
        return jobRepo.findByTitleContainingIgnoreCase(title);
    }
}
