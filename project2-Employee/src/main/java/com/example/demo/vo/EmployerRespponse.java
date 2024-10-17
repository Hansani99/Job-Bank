package com.example.demo.vo;

import com.example.demo.model.JobVacancy;

import java.util.List;

public class EmployerRespponse {

    private List<JobVacancy> jobSearchResults;


    public List<JobVacancy> getJobSearchResults() {
        return jobSearchResults;
    }

    public void setJobSearchResults(List<JobVacancy> jobSearchResults) {
        this.jobSearchResults = jobSearchResults;
    }
}
