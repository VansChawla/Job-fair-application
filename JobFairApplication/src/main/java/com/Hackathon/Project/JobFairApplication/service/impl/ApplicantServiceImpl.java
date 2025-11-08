package com.Hackathon.Project.JobFairApplication.service.impl;

import com.Hackathon.Project.JobFairApplication.dto.UserDTO;
import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.repository.ApplicantRepo;
import com.Hackathon.Project.JobFairApplication.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepo applicantRepo;
    private final ModelMapper modelMapper;
    @Override
    public Applicant findByEmailAndPassword ( String username, String password ) {
        return applicantRepo.findByEmailAndPassword(username,password);
    }

    @Override
    public void addNewApplicant ( UserDTO applicantDto ) {
        Applicant applicant=modelMapper.map(applicantDto,Applicant.class);
        applicantRepo.save(applicant);
    }

    @Override
    public Applicant getDetails ( Long id ) {
        return applicantRepo.getReferenceById (id);
    }

    @Override
    public boolean isProfileAvailable(String email){
        return applicantRepo.findByEmail ( email ) == null;

    }
}
