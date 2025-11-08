package com.Hackathon.Project.JobFairApplication.repository;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.JobApplied;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAppliedRepo extends JpaRepository<JobApplied,Long> {
    List<JobApplied> findByJobId( Long jobId);


}
