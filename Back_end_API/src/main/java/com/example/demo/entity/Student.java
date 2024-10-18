package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
	
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	@Id
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	
	@Column(name = "password")
	private String password;
	
	private Boolean isAdmin;
	
	public Student() {
		
	}
	
	public Student(String firstName,  String phone,String password) {
		super();
		this.firstName = firstName;
		this.phone = phone;
		this.password= password;
		this.isAdmin = false;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}
}
