package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_vacancy")
public class JobVacancy {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;
    @JsonFormat(pattern="yyyy/MM/dd")
    private Date datePosted;
    private String companyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_type")
    private JobType jobType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry")
    private JobIndustry industry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experiance_level")
    private JobExperienceLevel experianceLevel;

    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public JobIndustry getIndustry() {
        return industry;
    }

    public void setIndustry(JobIndustry industry) {
        this.industry = industry;
    }

    public JobExperienceLevel getExperianceLevel() {
        return experianceLevel;
    }

    public void setExperianceLevel(JobExperienceLevel experianceLevel) {
        this.experianceLevel = experianceLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
