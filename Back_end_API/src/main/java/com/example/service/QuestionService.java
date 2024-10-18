package com.example.service;

import java.util.List;

import com.example.demo.entity.Question;

public interface QuestionService {
	List<Question> getQuestionsByTestId(Long id);
	
	Question saveQues(Question question);
	
	void deleteQuestionById(Long id);
	
	Question getQuestionById(Long id);
	
	Question update(Question q);
}
