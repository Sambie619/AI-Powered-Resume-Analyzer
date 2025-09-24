package com.project.resumeanalyzer.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Lob
    private String resumeText;

    private LocalDate uploadDate;

    public Resume() {}

    public Resume(Long userId, String resumeText, LocalDate uploadDate) {
        this.userId = userId;
        this.resumeText = resumeText;
        this.uploadDate = uploadDate;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }
}
