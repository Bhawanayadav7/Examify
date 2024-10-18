package com.example.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentByphone(String phone);

	String getName(String phone);

//	Student updateStudent(Student student);
//	
//	void deleteStudentById(Long id);
}
