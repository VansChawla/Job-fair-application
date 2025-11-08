package com.Hackathon.Project.JobFairApplication.controller;

import com.Hackathon.Project.JobFairApplication.dto.ApplicantDTO;
import com.Hackathon.Project.JobFairApplication.dto.EmployerDTO;
import com.Hackathon.Project.JobFairApplication.dto.UserDTO;
import com.Hackathon.Project.JobFairApplication.entity.Applicant;
import com.Hackathon.Project.JobFairApplication.service.ApplicantService;
import com.Hackathon.Project.JobFairApplication.service.EmployerService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RegisterControllerModel {

    private final ApplicantService applicantService;
    private final EmployerService employerService;

    @GetMapping("/register")
    public String showRegisterForm( Model model,HttpSession session) {
        model.addAttribute("user", new UserDTO ());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String role,
                               @ModelAttribute  UserDTO userDTO,
                               HttpSession session,
                               Model model) {

        if ("candidate".equals(role)) {

            applicantService.addNewApplicant(userDTO);

            session.setAttribute("userType", "applicant");
            session.setAttribute("userName", userDTO.getUsername());

        } else if ("company".equals(role)) {
            employerService.addNewEmployee(userDTO);

            session.setAttribute("userType", "employer");
            session.setAttribute("userName", userDTO.getCompanyName());
        } else {
            model.addAttribute("error", "Invalid role selected");
            return "register";
        }

        return "redirect:/login";
    }


}
