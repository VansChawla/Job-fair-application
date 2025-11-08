package com.Hackathon.Project.JobFairApplication.repository;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant,Long> {
    public Applicant findByEmailAndPassword(String username,String password);
    public Applicant findByEmail(String email);

}
