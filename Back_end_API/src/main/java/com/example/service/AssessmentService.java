package com.example.service;

import java.util.List;

import com.example.demo.entity.Assessment;
import com.example.demo.entity.Question;
import com.example.demo.entity.Student;

public interface AssessmentService {
	List<Assessment> getAllAssessments();
	
	Assessment saveAssessment(Assessment assessment);
	
	void deleteAssessmentById(Long id);
	
	List<Assessment> getAllAssessmentsByTopic(String Topic);

	int quesById(Long id);

	int increment(Long id);

	Assessment update(Long id);
}
