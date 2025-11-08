package com.Hackathon.Project.JobFairApplication.controller;


import com.Hackathon.Project.JobFairApplication.entity.Job;
import com.Hackathon.Project.JobFairApplication.service.impl.JobImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeControllerModel{

    private static final Logger logger = LoggerFactory.getLogger(HomeControllerModel.class); // Initialize logger

    private final JobImpl job;
    @GetMapping("/home")
    public String home(Model model) {
        logger.info("Accessed home page");
        model.addAttribute("message", "Welcome to the Home Page!");
        return "/home"; // Loads home.html
    }
//    @GetMapping("/search")
//    public String searchJobs( @RequestParam("keyword") String keyword, Model model) {
//
//        List<Job> searchResults = job.searchJobsByTitle(keyword);
//
//        model.addAttribute("searchResults", searchResults);
//        model.addAttribute("keyword", keyword);
//
//        return "searchResults";
//    }
}
