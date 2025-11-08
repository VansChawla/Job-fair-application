package com.Hackathon.Project.JobFairApplication.service;

import com.Hackathon.Project.JobFairApplication.entity.Job;

import java.util.List;

public interface JobService {
    public List<Job> getAllJobsList();
    public List<Job> searchJobsByTitle(String title);
}
