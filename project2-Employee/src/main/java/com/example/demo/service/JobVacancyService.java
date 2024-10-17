package com.example.demo.service;

import com.example.demo.model.JobExperienceLevel;
import com.example.demo.model.JobIndustry;
import com.example.demo.model.JobType;
import com.example.demo.model.JobVacancy;

import java.util.List;

public interface JobVacancyService {

    List<JobVacancy> searchJobs(
            String title,
            String companyName,
            JobType jobType,
            JobIndustry industry,
            JobExperienceLevel experianceLevel
    );
}
