package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assessments")
public class Assessment {
	
	public void setTestTaken(int testTaken) {
		TestTaken = testTaken;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Tag", nullable = false)
	private String Tag;
	
	@Column(name = "Questions")
	private int Questions;
	
	@Column(name = "TestTaken")
	private int TestTaken;
	
	@Column(name = "Topic")
	private String Topic;
	
	
	public Assessment() {
		
	}
	
	public Assessment(String Tag, int Questions,String Topic) {
		super();
		this.Tag = Tag;
		this.Questions = Questions;
		this.Topic = Topic;
		this.TestTaken = 0;
	}
	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag() {
		return Tag;
	}
	public void setTag(String Tag) {
		this.Tag = Tag;
	}
	public int getQuestions() {
		return Questions;
	}
	public void setQuestions(int Questions) {
		this.Questions = Questions;
	}
	public int getTestTaken() {
		return TestTaken;
	}
}
