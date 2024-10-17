package com.example.demo.Controller;

import com.example.demo.dao.*;
import com.example.demo.model.*;
import com.example.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final String FIND_URL = "http://localhost:8080/employer/find/job";

    @Autowired
    UserDataRepo repo;

    @Autowired
    ContactDataRepo conRepo;

    @Autowired
    private JobExperienceLevelRepository expRepo;

    @Autowired
    private JobTypeRepository jobTypeRepo;

    @Autowired
    private JobIndustryRepository jobIndustryRepo;


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String showHome() {
        return "home";
    }

    @RequestMapping("/saveData")
    @ResponseBody
    public String saveData(UserData userData) {
        repo.save(userData);
        return "success";
    }


    @RequestMapping("/apply")
    public String showApply() {
        return "apply";
    }


    @RequestMapping("/ContactUs")
    public String Contact() {
        return "ContactUs";
    }

    @RequestMapping("/ContactData")
    @ResponseBody
    public String saveData(ContactData contactData) {
        conRepo.save(contactData);
        return "Success";
    }


    @RequestMapping("/vacancy")
    public String showvacancy() {
        return "vacancy";
    }


    @RequestMapping(value = "/searchJobs", method = RequestMethod.GET)
    public String viewSearchJobs(ModelMap modelMap) {
        List<JobExperienceLevel> experienceLevels = expRepo.findAll();
        List<JobIndustry> jobIndustries = jobIndustryRepo.findAll();
        List<JobType> jobTypes = jobTypeRepo.findAll();
        List<JobExperienceLevelVO> experienceLevelVOList = experienceLevels.stream().map(jobExperienceLevel ->
                new JobExperienceLevelVO(
                        jobExperienceLevel.getId(),
                        jobExperienceLevel.getName(),
                        jobExperienceLevel.getDescription()
                )).collect(Collectors.toList());
        modelMap.addAttribute(0);
        List<JobIndustryVO> jobIndustryVOList = jobIndustries.stream().map(jobIndustry ->
                new JobIndustryVO(
                        jobIndustry.getId(),
                        jobIndustry.getName(),
                        jobIndustry.getDescription()
                )).collect(Collectors.toList());
        List<JobTypeVO> jobTypeVOList = jobTypes.stream().map(jobType ->
                new JobTypeVO(
                        jobType.getId(),
                        jobType.getName(),
                        jobType.getDescription()
                )).collect(Collectors.toList());
        modelMap.addAttribute("experienceLevelVOList", experienceLevelVOList);
        modelMap.addAttribute("jobIndustryVOList", jobIndustryVOList);
        modelMap.addAttribute("jobTypeVOList", jobTypeVOList);
        return "searchjobs";
    }

    @RequestMapping(value = "/viewJob", method = RequestMethod.GET)
    public String viewJobDetails(ModelMap modelMap, @RequestParam Integer jobId) {
        SearchRequestVO searchRequest = new SearchRequestVO();
        searchRequest.setId(jobId);
        EmployerRespponse employerRespponse = restTemplate.postForObject(FIND_URL, searchRequest, EmployerRespponse.class);
        System.out.println("jobId:" + jobId);
        JobVacancyVO jobVacancy = null;
        if (employerRespponse.getJobSearchResults().size() > 0) {
            jobVacancy = employerRespponse.getJobSearchResults().get(0);
        }
        modelMap.addAttribute("jobVacancy", jobVacancy);
        return "viewJob";


    }


}
