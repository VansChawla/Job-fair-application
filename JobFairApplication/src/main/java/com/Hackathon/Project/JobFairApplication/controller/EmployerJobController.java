package com.Hackathon.Project.JobFairApplication.controller;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.service.EmployerJobService;
import com.Hackathon.Project.JobFairApplication.service.impl.EmployerJobImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class EmployerJobController {

    private static final Logger logger = LoggerFactory.getLogger(EmployerJobController.class);

    private final EmployerJobImpl employerJob;

    @GetMapping("/applicants")
    public String showApplicants(@PathVariable Long employerId, Model model) {
        logger.info("Entering showApplicants method with employerId: {}", employerId);
        // Get the list of applicants for the employer's jobs
        List<Applicant> applicants = employerJob.getAllJobList(employerId);

        // Add the list of applicants to the model
        model.addAttribute("applicants", applicants);

        return "applicants"; // The view template that displays the applicants
    }
}
