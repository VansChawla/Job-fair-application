package com.Hackathon.Project.JobFairApplication.service.impl;

import com.Hackathon.Project.JobFairApplication.dto.UserDTO;
import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.Employer;
import com.Hackathon.Project.JobFairApplication.repository.EmployerRepo;
import com.Hackathon.Project.JobFairApplication.service.ApplicantService;
import com.Hackathon.Project.JobFairApplication.service.EmployerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepo employerRepo;
    private final ModelMapper modelMapper;

    @Override
    public Employer findByEmailAndPassword ( String email, String password ) {
        return employerRepo.findByEmailAndPassword (email,password);
    }

    @Override
    public void addNewEmployee ( UserDTO employerDto ) {
        Employer employer=modelMapper.map(employerDto,Employer.class);
        employerRepo.save(employer);
    }

    @Override
    public Employer getDetails( Long id){
        return employerRepo.getReferenceById (id);
    }

    @Override
    public boolean isProfileAvailable(String email){
        return employerRepo.findByEmail ( email ) == null;

    }

}
