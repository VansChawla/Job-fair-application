package com.Hackathon.Project.JobFairApplication.repository;

import com.Hackathon.Project.JobFairApplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
    List<Job> findByTitleContainingIgnoreCase( String title);
}
