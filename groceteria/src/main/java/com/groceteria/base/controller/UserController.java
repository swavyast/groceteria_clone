package com.groceteria.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceteria.base.records.DtoGroceteriaUser;
import com.groceteria.base.records.UserControllerResponse;
import com.groceteria.base.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping(path = "/register")
	public ResponseEntity<UserControllerResponse> registerUser(@RequestBody DtoGroceteriaUser userData) {

		return ResponseEntity.ok(userService.registerUser(userData));
	}

}
