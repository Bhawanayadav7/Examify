package com.example.demo.entity;

//import javax.security.auth.PrivateCredentialPermission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qid;
	
	@Column(name = "text")
	private String Text;
	
	public void setQid(Long qid) {
		this.qid = qid;
	}

	@Column(name = "testId")
	private Long testId;
	
	@Column(name = "op1")
	private String op1;
	
	@Column(name = "op2")
	private String op2;
	
	@Column(name = "op3")
	private String op3;
	
	@Column(name = "op4")
	private String op4;
	
	@Column(name = "correct")
	private String correct;

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public Long getQid() {
		return qid;
	}
	
	public Question() {
		
	}

	public Question(String Text, Long testId, String op1, String op2, String op3, String op4, String correct) {
		super();
		this.Text = Text;
		this.testId = testId;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.correct = correct;
	}

	public String getText() {
		return Text;
	}

	public void setText(String Text) {
		this.Text = Text;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}
	
	
	
}
