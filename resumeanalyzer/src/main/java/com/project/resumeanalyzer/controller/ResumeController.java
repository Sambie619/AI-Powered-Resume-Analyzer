package com.project.resumeanalyzer.controller;

import com.project.resumeanalyzer.model.Resume;
import com.project.resumeanalyzer.nlp.ResumeAnalyzer;
import com.project.resumeanalyzer.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeRepository resumeRepository;

    @PostMapping
    public ResumeAnalysisResponse uploadAndAnalyzeResume(@RequestBody Resume resume) {
        resume.setUploadDate(LocalDate.now());
        Resume savedResume = resumeRepository.save(resume);
        Set<String> keywords = ResumeAnalyzer.extractKeywords(savedResume.getResumeText());
        return new ResumeAnalysisResponse(savedResume, keywords);
    }

    // Response wrapper class
    public static class ResumeAnalysisResponse {

        private Resume resume;
        private Set<String> keywords;

        public ResumeAnalysisResponse(Resume resume, Set<String> keywords) {
            this.resume = resume;
            this.keywords = keywords;
        }

        public Resume getResume() {
            return resume;
        }

        public void setResume(Resume resume) {
            this.resume = resume;
        }

        public Set<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(Set<String> keywords) {
            this.keywords = keywords;
        }
    }
}


