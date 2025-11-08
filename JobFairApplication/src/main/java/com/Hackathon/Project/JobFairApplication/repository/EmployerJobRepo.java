package com.Hackathon.Project.JobFairApplication.repository;

import com.Hackathon.Project.JobFairApplication.entity.EmployerJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerJobRepo extends JpaRepository<EmployerJob,Long> {
    List<EmployerJob> findByEmployerId( Long employerId);

}
