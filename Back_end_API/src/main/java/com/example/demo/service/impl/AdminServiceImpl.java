package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRpository;
import com.example.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	private AdminRpository adminRpository;
	
	public AdminServiceImpl(AdminRpository adminRpository) {
		super();
		this.adminRpository = adminRpository;
	}

	@Override
	public Admin getAdminByName(String Name) {
	    Optional<Admin> adminOptional = adminRpository.findById(Name);
	    if (adminOptional.isPresent()) {
	        return adminOptional.get();
	    } else {
	        // Handle case where student with given email is not found
	        return null; // or throw an exception, return a default value, etc.
	    }
	}
}
