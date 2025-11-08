package com.Hackathon.Project.JobFairApplication.controller;

import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.entity.Employer;

import com.Hackathon.Project.JobFairApplication.service.impl.ApplicantServiceImpl;
import com.Hackathon.Project.JobFairApplication.service.impl.EmployerServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequiredArgsConstructor
public class LoginControllerModel {

    private static final Logger logger = LoggerFactory.getLogger(LoginControllerModel.class); // Initialize logger

    private final ApplicantServiceImpl applicantService;
    private final EmployerServiceImpl employerService;

    @GetMapping("/login")
    public String showLoginPage() {
        logger.info("Displaying login page.");

        return "login"; // login.html (the form you posted)
    }
    @GetMapping("/login/recruiterhome")
    public String showRecruiterPage(HttpSession session) {
        Long candidateId = (Long) session.getAttribute ("userId");


        if (candidateId == null) {
            logger.warn("User session expired or invalid. Redirecting to login.");
            return "redirect:/login";
        }
        logger.info("User with ID {} accessed the recruiter home page.", candidateId);

        return "recruiterhome";
    }

    @GetMapping("/login/candidatehome")
    public String showCandidatePage(HttpSession session) {
        Long candidateId = (Long) session.getAttribute ("userId");

        if (candidateId == null) {
            logger.warn("User session expired or invalid. Redirecting to login page");

            return "redirect:/login"; // Or an error page
        }
        logger.info("User with ID {} accessed the candidate home page.", candidateId);

        return "candidatehome"; // login.html (the form you posted)
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        @RequestParam String role,
                        HttpSession session,
                        Model model) {
        logger.info("Login attempt with email: {} and role: {}", email, role);

        if (role.equals("candidate")) {
            Applicant user = applicantService.findByEmailAndPassword(email, password);
            if (user != null) {
                logger.info("User with email {} and role {} successfully logged in as candidate.", email, role);
                session.setAttribute("userType", "applicant");
                session.setAttribute("userName", user.getUsername());
                session.setAttribute("userId", user.getId());
                model.addAttribute("isLoggedIn", true);
                return "redirect:/login/candidatehome";
            } else {
                logger.warn("Invalid login attempt for candidate with email: {}", email);
            }
        } else if (role.equals("company")) {
            Employer user = employerService.findByEmailAndPassword(email, password);
            if (user != null) {
                logger.info("User with email {} and role {} successfully logged in as employer.", email, role);
                session.setAttribute("userType", "employer");
                session.setAttribute("userName", user.getCompanyName());
                session.setAttribute("userId", user.getId());
                model.addAttribute("isLoggedIn", true);
                return "redirect:/login/recruiterhome";
            } else {


                logger.warn("Invalid login attempt for employer with email: {}", email);
            }
        }
        logger.warn("Login failed for user with email: {} and role: {}", email, role);

        model.addAttribute("error", "Invalid credentials");
        return "login";

    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        logger.info("User has logged out. Session invalidated.");

        return "redirect:/home";
    }

}
