package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Assessment;
import com.example.demo.entity.Question;
import com.example.demo.entity.Student;
import com.example.demo.repository.AssessmentRepository;
import com.example.service.AssessmentService;


@Service
public class AssessmentServiceImpl implements AssessmentService{
	private AssessmentRepository assessmentRepository;
	
	public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
		super();
		this.assessmentRepository = assessmentRepository;
	}

	@Override
	public List<Assessment> getAllAssessments() {
		return assessmentRepository.findAll();
	}

	@Override
	public Assessment saveAssessment(Assessment assessment) {
		return assessmentRepository.save(assessment);
	}
	
	@Override
	public void deleteAssessmentById(Long id) {
		assessmentRepository.deleteById(id);	
	}
	
	@Override
	public List<Assessment> getAllAssessmentsByTopic(String Topic){
		List<Assessment> allAssessments = assessmentRepository.findAll();
		
		List<Assessment> allAssessmentsWithTopic = new ArrayList<>();
		for(Assessment a : allAssessments ) {
			if (a.getTopic().equals(Topic)) {
				allAssessmentsWithTopic.add(a);
			}
		}
		return allAssessmentsWithTopic;
	}
	
	@Override
	public int quesById(Long id) {
		Optional<Assessment> assementOptional = assessmentRepository.findById(id);
	    if (assementOptional.isPresent()) {
	        return assementOptional.get().getQuestions();
	    } else {
	        // Handle case where student with given email is not found
	        return 0; // or throw an exception, return a default value, etc.
	    }
		
	}
	
	@Override
	public int increment(Long id) {
	    Optional<Assessment> assessmentOptional = assessmentRepository.findById(id);
	    if (assessmentOptional.isPresent()) {
	        Assessment assessment = assessmentOptional.get();
	        int updatedTestTaken = assessment.getTestTaken() + 1;
	        assessment.setTestTaken(updatedTestTaken);
	        assessmentRepository.save(assessment); // Save the updated entity
	        System.out.println("Updated testTaken: " + updatedTestTaken);
	        return updatedTestTaken;
	    } else {
	        System.out.println("Assessment not found for ID: " + id);
	        // Handle case where student with given ID is not found
	        return 0; // or throw an exception, return a default value, etc.
	    }
	}
	
	@Override
	public Assessment update(Long id) {
	    Optional<Assessment> assessmentOptional = assessmentRepository.findById(id);
	    if (assessmentOptional.isPresent()) {
	        Assessment existingAssessment = assessmentOptional.get();
	        // Decrease the number of questions by 1
	        existingAssessment.setQuestions(existingAssessment.getQuestions() - 1);
	        return assessmentRepository.save(existingAssessment); // Save the updated entity
	    } else {
	        System.out.println("Assessment not found for ID: " + id);
	        // Handle case where assessment with given ID is not found
	        return null; // or throw an exception, return a default value, etc.
	    }
	}


}