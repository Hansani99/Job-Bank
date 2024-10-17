package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "experiance_level")
public class JobExperienceLevel {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "experianceLevel")
    private List<JobVacancy> vacancies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<JobVacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<JobVacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
