package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Attempt_test;
import com.example.demo.entity.Student;
import com.example.demo.repository.AttemptRepository;
import com.example.service.AttemptService;


@Service
public class AttemptServiceImpl implements AttemptService {
	
	private AttemptRepository attemptRepository;
	
	
	public AttemptServiceImpl(AttemptRepository attemptRepository) {
		super();
		this.attemptRepository = attemptRepository;
	}


	@Override
	public Attempt_test saveAttempt(Attempt_test attempt) {
		return attemptRepository.save(attempt);
	}
	
	@Override
	public Attempt_test findAttempt(Long id) {
		Optional<Attempt_test> attemptOptional = attemptRepository.findById(id);
	    if (attemptOptional.isPresent()) {
	        return attemptOptional.get();
	    } else {
	        // Handle case where student with given email is not found
	        return null; // or throw an exception, return a default value, etc.
	    }
	}
}
