package com.example.demo.service;

import com.example.demo.dao.JobVacancyRepository;
import com.example.demo.model.JobExperienceLevel;
import com.example.demo.model.JobIndustry;
import com.example.demo.model.JobType;
import com.example.demo.model.JobVacancy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobVacancyServiceImpl implements JobVacancyService {

    @Autowired
    JobVacancyRepository jobVacancyRepository;

    @Override
    public List<JobVacancy> searchJobs(String title, String companyName, JobType jobType, JobIndustry industry, JobExperienceLevel experianceLevel) {
        return jobVacancyRepository.findAll(new Specification<JobVacancy>() {
            @Override
            public Predicate toPredicate(Root<JobVacancy> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(title)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%" + title + "%")));
                }
                if (StringUtils.isNotEmpty(companyName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("companyName"), "%" + companyName + "%")));
                }
                if (jobType != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("jobType"), jobType)));
                }

                if (industry != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("industry"), industry)));
                }
                if (experianceLevel != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("experianceLevel"), experianceLevel)));
                }
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("datePosted")));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
}
