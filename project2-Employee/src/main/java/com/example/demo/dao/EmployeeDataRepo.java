package com.example.demo.dao;

import com.example.demo.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataRepo extends JpaRepository<EmployeeData,Integer>{

}
