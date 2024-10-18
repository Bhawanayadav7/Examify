package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Attempt_test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long testId;
	
	@Column
	private Long studentId;
	
	@Column
	private Long score;


	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Attempt_test() {
		
	}
	
	public Attempt_test(Long testId, Long studentId, Long score) {
		super();
		this.testId = testId;
		this.studentId = studentId;
		this.score = score;
	}

	public Long getTestId() {
		return testId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	
	
	
}
