package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

	private final AddressRepository repository;
	
	// TODO Methods here ....
}
