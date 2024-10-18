package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Assessment;
import com.example.demo.entity.Student;
import com.example.service.AssessmentService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AssessmentController {
	
	private AssessmentService assessmentService;

	public AssessmentController(AssessmentService assessmentService) {
		super();
		this.assessmentService = assessmentService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/allAssessment")
    public List<Assessment> listAssessments() {
        return assessmentService.getAllAssessments();
    }
	
	@PostMapping("/createAssessment")
	public Assessment newAssessment(@RequestBody Assessment newAssessment) {
		return assessmentService.saveAssessment(newAssessment);
	}
	
	@DeleteMapping("/deleteAssessment/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		assessmentService.deleteAssessmentById(id);
	  }
	
	@GetMapping("/allAssessment/{Topic}")
    public List<Assessment> listAssessmentsByTopic(@PathVariable String Topic) {
//		System.out.println(assessmentService.getAllAssessmentsByTopic(Topic));
        return assessmentService.getAllAssessmentsByTopic(Topic);
    }
	
	@GetMapping("/getQuestions/{id}")
	public int getQuestions(@PathVariable Long id) {
		return assessmentService.quesById(id);
	}
	
	@GetMapping("/incrementCount/{id}")
	public int increment(@PathVariable Long id) {
		return assessmentService.increment(id);
	}
	
	@PutMapping("/updateAssessment/{id}")
	public Assessment updateAssessment(@PathVariable Long id) {
		return assessmentService.update(id);
	}
	
}
