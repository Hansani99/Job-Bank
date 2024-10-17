package com.example.demo.dao;

import com.example.demo.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDataRepo extends JpaRepository <ContactData,Integer>{

	
}
