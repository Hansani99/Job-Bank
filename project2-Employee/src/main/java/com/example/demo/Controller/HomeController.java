package com.example.demo.Controller;

import com.example.demo.dao.*;
import com.example.demo.model.*;
import com.example.demo.vo.JobExperienceLevelVO;
import com.example.demo.vo.JobIndustryVO;
import com.example.demo.vo.JobTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    EmployeeDataRepo repo;

    @Autowired
    ContactDataRepo conRepo;

    @Autowired
    private JobExperienceLevelRepository expRepo;

    @Autowired
    private JobTypeRepository jobTypeRepo;

    @Autowired
    private JobIndustryRepository jobIndustryRepo;

    @RequestMapping("/home")
    public String show() {
        return "home";
    }

    @RequestMapping("/JobSeekersDetails")
    public String showSeekers() {
        return "JobSeekersDetails";
    }


    @RequestMapping("/AddVacancy")
    public String showVacancies() {
        return "AddVacancy";
    }

    @RequestMapping("/saveData")
    @ResponseBody
    public String saveData(EmployeeData employeeData) {
        return "success";
    }

    @RequestMapping("/ContactUs")
    public String showContact() {
        return "ContactUs";
    }

    @RequestMapping("/saveConData")
    @ResponseBody
    public String saveConData(ContactData contactData) {
        return "success";
    }

    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Autowired
    private JobIndustryRepository jobIndustryRepository;

    @Autowired
    private JobExperienceLevelRepository jobExperienceLevelRepository;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;

    @RequestMapping(value = "/addNewJob", method = RequestMethod.GET)
    public String viewAddNewJob(ModelMap modelMap) {
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
        modelMap.addAttribute("JobVacancyModel", new JobVacancyFormModel());

        return "addNewJob";
    }

    @RequestMapping(value = "/addNewJobSuccess", method = RequestMethod.GET)
    public String addNewJobSuccess(ModelMap modelMap) {
        return "newJobSuccess";
    }


    @RequestMapping(value = "/createNewJob", method = RequestMethod.POST)
    public String createNewJob(ModelMap model, JobVacancyFormModel jobVacancyModel, BindingResult result) {
        //List<JobExperienceLevel> experienceLevels = expRepo.findAll();
        JobType jobType = null;
        JobIndustry jobIndustry = null;
        JobExperienceLevel experienceLevel = null;
        if (jobVacancyModel.getJobType() != null && jobVacancyModel.getJobType() > 0) {
            Optional<JobType> jobTypeOptional = jobTypeRepository.findById(jobVacancyModel.getJobType());
            jobType = jobTypeOptional.orElse(null);

        }
        if (jobVacancyModel.getIndustry() != null && jobVacancyModel.getIndustry() > 0) {
            Optional<JobIndustry> jobIndustryOptional = jobIndustryRepository.findById(jobVacancyModel.getIndustry());
            jobIndustry = jobIndustryOptional.orElse(null);
        }

        if (jobVacancyModel.getExpLevel() != null && jobVacancyModel.getExpLevel() > 0) {
            Optional<JobExperienceLevel> jobExpLevelOptional = jobExperienceLevelRepository.findById(jobVacancyModel.getExpLevel());
            experienceLevel = jobExpLevelOptional.orElse(null);
        }

        JobVacancy jobVacancy = new JobVacancy();
        jobVacancy.setJobType(jobType);
        jobVacancy.setCompanyName(jobVacancyModel.getCompanyName());
        jobVacancy.setDescription(jobVacancyModel.getDescription());
        jobVacancy.setDatePosted(new Date());
        jobVacancy.setIndustry(jobIndustry);
        jobVacancy.setExperianceLevel(experienceLevel);
        jobVacancy.setTitle(jobVacancyModel.getTitle());

        jobVacancyRepository.save(jobVacancy);
        return "redirect:/addNewJobSuccess";


    }
}
