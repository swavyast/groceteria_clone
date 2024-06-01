package com.groceteria.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceteria.base.records.DtoVendor;
import com.groceteria.base.records.VendorControllerResponse;
import com.groceteria.base.service.VendorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
public class VendorController {

	private final VendorService vendorService;

	@PostMapping("/register")
	public ResponseEntity<VendorControllerResponse> registerVendor(@RequestBody DtoVendor vendorData) {

		return ResponseEntity.ok(vendorService.registerVendor(vendorData));

	}
}
