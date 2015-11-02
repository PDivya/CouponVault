package com.couponvault.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.couponvault.repositories.UserDetailRepository;

@Controller
public class MainController {
	
	@Autowired
	UserDetailRepository userDetailRepo;
	
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  System.out.println(userDetailRepo.findAllNative());
	  model.setViewName("index");
	  
	  return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();
		
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
		
	  model.setViewName("403");
	  return model;

	}
	 @RequestMapping("/example")
	    String example(Model model) {
	        model.addAttribute("exampleText", "Welcome to Thymleaf !");
	        model.addAttribute("now", new Date());
	      //  model.addAttribute("clients", clientRepository.findAll());

	        return "example";
	    }


}