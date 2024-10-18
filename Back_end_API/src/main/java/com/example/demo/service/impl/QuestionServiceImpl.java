package com.example.demo.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Assessment;
import com.example.demo.entity.Question;
import com.example.demo.entity.Student;
import com.example.demo.repository.QuestionRepository;
import com.example.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService{
	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}
	
	@Override
	public Question saveQues(Question question) {
		return questionRepository.save(question);
	}
	
	@Override
	public List<Question> getQuestionsByTestId(Long id){
		List<Question> allQuestions = questionRepository.findAll();
		List<Question> testQuestions = new ArrayList<>();
		for(Question q: allQuestions) {
			if(q.getTestId()==id) {
				testQuestions.add(q);
			}
		}
		return testQuestions;
	}
	
	@Override
	public void deleteQuestionById(Long id) {
		questionRepository.deleteById(id);
	}
	
	@Override
	public Question getQuestionById(Long id) {
		Optional<Question> questionOptional = questionRepository.findById(id);
	    if (questionOptional.isPresent()) {
	        return questionOptional.get();
	    } else {
	        // Handle case where student with given email is not found
	        return null; // or throw an exception, return a default value, etc.
	    }
	}
	
	@Override
	public Question update(Question q) {
		return questionRepository.save(q);
	}
	
	
}
