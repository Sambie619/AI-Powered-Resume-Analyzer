package com.project.resumeanalyzer.model;



import jakarta.persistence.*;

@Entity
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Lob
    private String jobText;

    public JobDescription() {}

    public JobDescription(Long userId, String jobText) {
        this.userId = userId;
        this.jobText = jobText;
    }

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

    public String getJobText() {
        return jobText;
    }

    public void setJobText(String jobText) {
        this.jobText = jobText;
    }
}
