package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.GroceteriaUserAddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroceteriaUserAddressService {

	private final GroceteriaUserAddressRepository repository;
	
	// TODO Methods here ....
}
