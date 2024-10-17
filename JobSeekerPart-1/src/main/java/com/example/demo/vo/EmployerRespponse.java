package com.example.demo.vo;


import java.util.List;

public class EmployerRespponse {

    private List<JobVacancyVO> jobSearchResults;


    public List<JobVacancyVO> getJobSearchResults() {
        return jobSearchResults;
    }

    public void setJobSearchResults(List<JobVacancyVO> jobSearchResults) {
        this.jobSearchResults = jobSearchResults;
    }
}
