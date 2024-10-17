package com.example.demo.dao;

import com.example.demo.model.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobVacancyRepository extends JpaRepository<JobVacancy, Integer>, JpaSpecificationExecutor<JobVacancy> {

    /*@Query("SELECT JV FROM " +
            " JobVacancy JV" +
            " WHERE" +
            " (JV.title IS NULL OR JV.title LIKE %:title%)" +
            " AND (JV.companyName IS NULL" +
            " OR JV.companyName LIKE %:companyName%)" +
            " AND (JV.jobType IS NULL OR JV.jobType =:jobType)" +
            " AND (JV.industry IS NULL OR JV.industry =:industry)" +
            " AND (JV.experianceLevel IS NULL" +
            " OR JV.experianceLevel =:experianceLevel)")
    List<JobVacancy> searchJobs(
            @Param("title") String title,
            @Param("companyName") String companyName,
            @Param("jobType") JobType jobType,
            @Param("industry") JobIndustry industry,
            @Param("experianceLevel") JobExperienceLevel experianceLevel
    );

    @Query("SELECT JV FROM " +
            " JobVacancy JV" +
            " WHERE" +
            " (JV.title IS NULL OR JV.title LIKE %:title%)" +
            " AND (JV.companyName IS NULL" +
            " OR JV.companyName LIKE %:companyName%)")
    List<JobVacancy> searchJobs2(
            @Param("title") String title,
            @Param("companyName") String companyName
    );

    @Query("SELECT JV FROM " +
            " JobVacancy JV" +
            " WHERE" +
            " (JV.title IS NULL OR JV.title LIKE %:title%)" +
            " AND (JV.companyName IS NULL" +
            " OR JV.companyName LIKE %:companyName%)" +
            " AND (JV.jobType IS NULL OR JV.jobType =:jobType)")
    List<JobVacancy> searchJobs3(
            @Param("title") String title,
            @Param("companyName") String companyName,
            @Param("jobType") JobType jobType
    );
*/


}
