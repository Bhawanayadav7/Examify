package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.service.StudentService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	private HttpSession session;
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/Allstudent")
    public List<Student> listStudents() {
        return studentService.getAllStudents(); 
    }
	
	@PostMapping("/createStudent")
	public Student newStudent(@RequestBody Student newStudent) {
		return studentService.saveStudent(newStudent);
	}
	
	@PostMapping("/studentLogin")
    public Boolean Login(@RequestBody Student student, HttpServletRequest request) {
        Student dataStudent = studentService.getStudentByphone(student.getphone());

        if (dataStudent != null && dataStudent.getPassword().equals(student.getPassword())) {
            // Store the logged-in student in session
            session = request.getSession(); // No need to create a new session explicitly
            session.setAttribute("loggedInStudent", dataStudent);
            System.out.println("Logged-in Student: " + session.getAttribute("loggedInStudent"));
            return true;
        }
        return false;
    }
	@PostMapping("/checkAdmin")
	public Boolean checkAdmin(@RequestBody String password) {
		Student admin = studentService.getStudentByphone("Admin");
		return admin != null && admin.getPassword().equals(password);
	}
	
	@GetMapping("/checkSession")
	public Boolean checkSession(HttpServletRequest request) {
	    return session != null && session.getAttribute("loggedInStudent") != null;
	}
	
	@GetMapping("/logout")
    public Boolean logout(HttpServletRequest request) {
        // Invalidate the session (destroy it)
        if (session != null) {
            session.invalidate();
            System.out.println("Session invalidated.");
            return true;
        }
        return false;
    }
	
	@GetMapping("/student/{phone}")
    public ResponseEntity<String> getName(@PathVariable String phone) {
        String name = studentService.getName(phone);
        if (name != null) {
            return ResponseEntity.ok().body("{\"name\": \"" + name + "\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Student not found\"}");
        }
    }
}
