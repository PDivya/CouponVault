package com.couponvault.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.couponvault.model.User;
import com.couponvault.repositories.UserRepository;

@org.springframework.web.bind.annotation.RestController

public class RestController {
		
	@Autowired
	UserRepository userRepo;
	@RequestMapping("/greeting")
	public User hello(){
		System.out.println(userRepo.findByUsername("gagan").getCoupons());
		return userRepo.findByUsername("gagan");
	}	
}
