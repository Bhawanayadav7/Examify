package com.example.service;
import com.example.demo.entity.Attempt_test;

public interface AttemptService {
	Attempt_test saveAttempt(Attempt_test attempt);
	
	Attempt_test findAttempt(Long id);
}
