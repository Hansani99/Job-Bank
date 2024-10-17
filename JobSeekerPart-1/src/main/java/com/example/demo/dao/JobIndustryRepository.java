package com.example.demo.dao;

import com.example.demo.model.JobIndustry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobIndustryRepository extends JpaRepository<JobIndustry, Integer> {
}
