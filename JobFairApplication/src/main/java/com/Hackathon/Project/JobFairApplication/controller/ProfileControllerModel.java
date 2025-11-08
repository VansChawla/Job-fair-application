package com.Hackathon.Project.JobFairApplication.controller;


import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.Employer;
import com.Hackathon.Project.JobFairApplication.service.impl.ApplicantServiceImpl;
import com.Hackathon.Project.JobFairApplication.service.impl.EmployerServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProfileControllerModel {
    private final ApplicantServiceImpl applicantService;
    private final EmployerServiceImpl employerService;

    @GetMapping("/applicantprofile")
    public String getCandidateProfile( Model model, HttpSession session ){
        Long id= (Long) session.getAttribute ("userId");
        Applicant applicant=applicantService.getDetails (id);
        model.addAttribute ("user",applicant);
        return "/applicantprofile";
    }
    @GetMapping("/employerprofile")
    public String getEmployerProfile( Model model, HttpSession session ){
        Long id= (Long) session.getAttribute ("userId");
        Employer employer=employerService.getDetails(id);
        model.addAttribute ("employer",employer);
        return "/employerprofile";
    }
}
