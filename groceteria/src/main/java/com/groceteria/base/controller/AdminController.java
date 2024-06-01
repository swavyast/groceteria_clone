package com.groceteria.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceteria.base.exception.InstantiationFailedException;
import com.groceteria.base.records.AdminControllerResponse;
import com.groceteria.base.records.DtoAdmin;
import com.groceteria.base.records.DtoLogin;
import com.groceteria.base.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;

	@PostMapping("/register")
	public ResponseEntity<AdminControllerResponse> register(@RequestBody DtoAdmin userData)
			throws InstantiationFailedException {

		return ResponseEntity.ok(adminService.register(userData));
	}

	@PostMapping("/login")
	public ResponseEntity<AdminControllerResponse> login(@RequestBody DtoLogin userData)
			throws InstantiationFailedException {

		return ResponseEntity.ok(adminService.login(userData));
	}
}
