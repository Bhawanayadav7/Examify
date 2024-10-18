package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Assessment;
import com.example.demo.entity.Question;
import com.example.service.QuestionService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@GetMapping("/allQuestion/{Test_id}")
    public List<Question> listQuestions(@PathVariable Long Test_id ) {
        return questionService.getQuestionsByTestId(Test_id);
    }
	
	 
	@PostMapping("/createQuestion")
	public Question newQuestion(@RequestBody Question newQuestion) {
		return questionService.saveQues(newQuestion);
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	void deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestionById(id);
	}
	
	@GetMapping("/checkQuestion/{id}")
	public ResponseEntity<String> check(@PathVariable Long id) {
	    Question databaseQuestion = questionService.getQuestionById(id);
	    System.out.println(databaseQuestion.getCorrect());
	    // Create a JSON response with the correct option
	    String correctOption = databaseQuestion.getCorrect();
	    return ResponseEntity.ok().body("{\"correct\": \"" + correctOption + "\"}");
	}
	
	@PutMapping("/updateQuestion")
	public Question updateAssessment( @RequestBody Question q) {
		return questionService.update(q);
	}
	 
}
