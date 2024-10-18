package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Attempt_test;
import com.example.service.AttemptService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AttemptController {
	
	
	private AttemptService attemptService;

	public AttemptController(AttemptService attemptService) {
		super();
		this.attemptService = attemptService;
	}
	
	@PostMapping("/attempt")
	public Attempt_test saveAttempt_test(@RequestBody Attempt_test attempt) {
		return attemptService.saveAttempt(attempt);
	}
	
	@GetMapping("/getScore/{id}")
	public Long score(@PathVariable Long id) {
		return attemptService.findAttempt(id).getScore();
	}
}
