package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	private AdminService adminService;
	
	private HttpSession session;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	
	@PostMapping("/adminLogin")
    public Boolean Login(@RequestBody Admin admin, HttpServletRequest request) {
        Admin dataAdmin  = adminService.getAdminByName(admin.getUsername());

        if (dataAdmin != null && dataAdmin.getPassword().equals(admin.getPassword())) {
            // Store the logged-in student in session
            session = request.getSession(); // No need to create a new session explicitly
            session.setAttribute("loggedInAdmin", dataAdmin);
            System.out.println("Logged-in Admin: " + session.getAttribute("loggedInAdmin"));
            return true;
        }
        return false;
    }
	
	@GetMapping("/checkSessionAdmin")
	public Boolean checkSession(HttpServletRequest request) {
	    return session != null && session.getAttribute("loggedInAdmin") != null;
	}
	
	@GetMapping("/logoutAdmin")
    public Boolean logout(HttpServletRequest request) {
        // Invalidate the session (destroy it)
        if (session != null) {
            session.invalidate();
            System.out.println("Session invalidated.");
            return true;
        }
        return false;
    }
}
