package com.example.demo.vo;

public class JobVacancyVO {


    private int id;
    private String title;
    private String datePosted;
    private String companyName;
    private JobTypeVO jobType;
    private JobIndustryVO industry;
    private JobExperienceLevelVO experianceLevel;
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

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public JobTypeVO getJobType() {
        return jobType;
    }

    public void setJobType(JobTypeVO jobType) {
        this.jobType = jobType;
    }

    public JobIndustryVO getIndustry() {
        return industry;
    }

    public void setIndustry(JobIndustryVO industry) {
        this.industry = industry;
    }

    public JobExperienceLevelVO getExperianceLevel() {
        return experianceLevel;
    }

    public void setExperianceLevel(JobExperienceLevelVO experianceLevel) {
        this.experianceLevel = experianceLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
