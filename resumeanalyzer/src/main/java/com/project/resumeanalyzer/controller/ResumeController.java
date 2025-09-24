package com.project.resumeanalyzer.controller;

import com.project.resumeanalyzer.model.Resume;
import com.project.resumeanalyzer.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeRepository resumeRepository;

    @PostMapping
    public Resume uploadResume(@RequestBody Resume resume) {
        resume.setUploadDate(LocalDate.now());
        return resumeRepository.save(resume);
    }
}