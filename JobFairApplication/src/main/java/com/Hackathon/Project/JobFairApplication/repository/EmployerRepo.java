package com.Hackathon.Project.JobFairApplication.repository;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer,Long> {
    public Employer findByEmailAndPassword( String username, String password);
    public Employer findByEmail(String email);

}
