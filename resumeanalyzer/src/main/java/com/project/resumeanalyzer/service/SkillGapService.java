package com.project.resumeanalyzer.service;

import com.project.resumeanalyzer.nlp.ResumeAnalyzer;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SkillGapService {

    // Returns keywords present in job description but missing in resume
    public Set<String> findSkillGap(Set<String> resumeKeywords, Set<String> jobKeywords) {
        Set<String> skillGap = new HashSet<>(jobKeywords);
        skillGap.removeAll(resumeKeywords); // Remove common skills
        return skillGap;
    }

    public Set<String> extractKeywords(String text) {
        return ResumeAnalyzer.extractKeywords(text);
    }
}