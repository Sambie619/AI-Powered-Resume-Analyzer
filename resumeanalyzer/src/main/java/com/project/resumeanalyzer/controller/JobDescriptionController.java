package com.project.resumeanalyzer.controller;

import com.project.resumeanalyzer.model.JobDescription;
import com.project.resumeanalyzer.repository.JobDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobdescriptions")
public class JobDescriptionController {
    @GetMapping("/test")
    public String test() {
        return "JobDescription API is working";
    }


    @Autowired
    private JobDescriptionRepository jobDescriptionRepository;

    @PostMapping
    public JobDescription uploadJobDescription(@RequestBody JobDescription jobDescription) {
        return jobDescriptionRepository.save(jobDescription);
    }
}