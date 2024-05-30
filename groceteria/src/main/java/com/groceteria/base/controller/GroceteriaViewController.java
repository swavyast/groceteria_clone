package com.groceteria.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroceteriaViewController {

	@GetMapping("/")
	public String homePageView() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPageView() {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String registrationPageView() {
		
		return "register";
	}
}