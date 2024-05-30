package com.groceteria.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceteria.base.dto.DtoGroceteriaUser;
import com.groceteria.base.model.GroceteriaUserControllerResponse;
import com.groceteria.base.service.GroceteriaUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class GroceteriaUserController {

	private final GroceteriaUserService userService;

	@PostMapping(path = "/register")
	public ResponseEntity<GroceteriaUserControllerResponse> registerUser(@RequestBody DtoGroceteriaUser userData) {

		return ResponseEntity.ok(userService.registerUser(userData));
	}

}
