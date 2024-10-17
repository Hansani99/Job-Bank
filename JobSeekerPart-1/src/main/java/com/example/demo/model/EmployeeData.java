package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="employee_data")
public class EmployeeData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String name;
	private String email;
	private int phoneNumber;
	private String position;
	
	
	public  void Employee() {
		
	}
	
	public void Employee(int id,String title,String name,int phoneNumber,String position) {
		this.id=id;
		this.name=name;
		this.title=title;
		this.phoneNumber=phoneNumber;
		this.position=position;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
	

}
