package com.groceteria.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/")
	public String homeView() {

		return "index";
	}

	@GetMapping("/register")
	public String userRegistrationView() {

		return "register";
	}

	@GetMapping("/login")
	public String userLoginView() {

		return "login";
	}

	@GetMapping("/user/home")
	public String userHomeView() {

		return "/user/home";
	}

	@GetMapping("/logout")
	public String logoutView() {

		return "logout";
	}

	@GetMapping("/admin/register")
	public String adminRegistrationView() {

		return "admin/register";
	}

	@GetMapping("/admin/login")
	public String adminLoginView() {

		return "admin/login";
	}

	@GetMapping("/admin/home")
	public String adminHomeView() {

		return "admin/home";
	}

	@GetMapping("/vendor/register")
	public String vendorRegistrationView() {

		return "vendor/register";
	}

	@GetMapping("/vendor/login")
	public String vendorLoginView() {

		return "vendor/login";
	}

	@GetMapping("/vendor/home")
	public String vendorHomeView() {

		return "vendor/home";
	}

}