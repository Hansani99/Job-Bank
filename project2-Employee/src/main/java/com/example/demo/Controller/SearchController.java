package com.example.demo.Controller;

import com.example.demo.dao.JobExperienceLevelRepository;
import com.example.demo.dao.JobIndustryRepository;
import com.example.demo.dao.JobTypeRepository;
import com.example.demo.dao.JobVacancyRepository;
import com.example.demo.model.JobExperienceLevel;
import com.example.demo.model.JobIndustry;
import com.example.demo.model.JobType;
import com.example.demo.model.JobVacancy;
import com.example.demo.service.JobVacancyServiceImpl;
import com.example.demo.vo.EmployerRespponse;
import com.example.demo.vo.SearchRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {

    @Autowired
    private JobVacancyRepository jobVacancyRepository;

    @Autowired
    private JobVacancyServiceImpl jobVacancyService;

    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Autowired
    private JobIndustryRepository jobIndustryRepository;

    @Autowired
    private JobExperienceLevelRepository jobExperienceLevelRepository;

    @PostMapping("/search/jobs")
    public ResponseEntity<EmployerRespponse> searchJobs(@RequestBody SearchRequestVO searchRequest) {
        JobType jobType = null;
        JobIndustry jobIndustry = null;
        JobExperienceLevel experienceLevel = null;
        if (searchRequest.getJobType() != null && searchRequest.getJobType() > 0) {
            Optional<JobType> jobTypeOptional = jobTypeRepository.findById(searchRequest.getJobType());
            jobType = jobTypeOptional.orElse(null);
            //jobType =
        }
        if (searchRequest.getIndustry() != null && searchRequest.getIndustry() > 0) {
            Optional<JobIndustry> jobIndustryOptional = jobIndustryRepository.findById(searchRequest.getIndustry());
            jobIndustry = jobIndustryOptional.orElse(null);
        }

        if (searchRequest.getExpLevel() != null && searchRequest.getExpLevel() > 0) {
            Optional<JobExperienceLevel> jobExpLevelOptional = jobExperienceLevelRepository.findById(searchRequest.getExpLevel());
            experienceLevel = jobExpLevelOptional.orElse(null);
        }

        List<JobVacancy> filteredVacancies = jobVacancyService.searchJobs(
                searchRequest.getTitle(),
                searchRequest.getCompanyName(),
                jobType,
                jobIndustry,
                experienceLevel
        );
        EmployerRespponse employerRespponse = new EmployerRespponse();
        employerRespponse.setJobSearchResults(filteredVacancies);
        return ResponseEntity.of(Optional.of(employerRespponse));

    }

    @PostMapping("/find/job")
    public ResponseEntity<EmployerRespponse> findJob(@RequestBody SearchRequestVO searchRequest) {
        Optional<JobVacancy> jobVacancyOpt = jobVacancyRepository.findById(Integer.parseInt(searchRequest.getId()));
        JobVacancy jobVacancy = jobVacancyOpt.orElse(null);
        ArrayList<JobVacancy> arrayList = new ArrayList<>();
        arrayList.add(jobVacancy);
        EmployerRespponse employerRespponse = new EmployerRespponse();
        employerRespponse.setJobSearchResults(arrayList);
        return ResponseEntity.of(Optional.of(employerRespponse));

    }

}
