package com.example.demo.dao;

import com.example.demo.model.JobExperienceLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceLevelRepository extends JpaRepository<JobExperienceLevel, Integer> {
}
