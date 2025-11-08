package com.Hackathon.Project.JobFairApplication.controller;

import com.Hackathon.Project.JobFairApplication.dto.JobDTO;
import com.Hackathon.Project.JobFairApplication.service.impl.EmployerJobImpl;
import com.Hackathon.Project.JobFairApplication.service.impl.JobAppliedImpl;
import com.Hackathon.Project.JobFairApplication.service.impl.JobImpl;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@AllArgsConstructor
public class JobPostingController {

    private static final Logger logger = LoggerFactory.getLogger(JobPostingController.class); // Initialize logger

    private final JobImpl job;
    private final JobAppliedImpl jobApplied;
    private final EmployerJobImpl employerJob;

    @GetMapping("/postjob")
    public String showJobForm( Model model,HttpSession session){
        Long candidateId = (Long) session.getAttribute ("userId");

        if (candidateId == null) {
            logger.warn("User session expired or invalid. Redirecting to login.");
            return "redirect:/login";
        }
        logger.info("User with ID {} is accessing the job posting form.", candidateId);
        model.addAttribute("jobNew",new JobDTO());
        return "postjob";
    }


    @PostMapping("/JobFair/saveJob")
    public String saveJob(@ModelAttribute("jobNew") JobDTO jobDto, Model model,HttpSession session) {
        Long candidateId = (Long) session.getAttribute ("userId");

        if (candidateId == null) {
            logger.warn("User session expired or invalid. Redirecting to login page.");
            return "redirect:/login"; // Or an error page
        }
        jobDto.setCompanyName ( (String) session.getAttribute ( "userName" ) );
        logger.info("User with ID {} is saving a new job posting for company: {}", candidateId, jobDto.getCompanyName());


        job.saveNewJob (jobDto,candidateId);
        logger.info("Job saved successfully by user with ID {}.", candidateId);

        return "/recruiterhome"; // success page (JobSuccess.html)
    }

    @GetMapping("/viewalljobs")
    public String getAllJobList( Model model, HttpSession session ){
        Long candidateId = (Long) session.getAttribute ("userId");

        if (candidateId == null) {
            logger.warn("User session expired or invalid and Redirecting to login.");
            return "redirect:/login"; // Or an error page
        }
        logger.info("User with ID {} is viewing all job listings.", candidateId);

        model.addAttribute ("jobs",job.getAllJobsList());

        return "viewalljobs";
    }

    @PostMapping("/applyjobs")
    public String applyJobs( @RequestParam String id, Model model,  HttpSession session ){
        Long candidateId = (Long) session.getAttribute ("userId");

        if (candidateId == null) {
            logger.warn("User session expired or invalid and Redirecting to login page.");
            return "redirect:/login"; // Or an error page
        }
        jobApplied.applyForJob (Long.parseLong(id), (Long) session.getAttribute ("userId") );
        logger.info("User with ID {} successfully applied for job with ID {}.", candidateId, id);

        return "redirect:/viewalljobs";
    }


}