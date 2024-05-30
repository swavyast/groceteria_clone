package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.ProductCatagoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCatagoryService {

	private final ProductCatagoryRepository repository;
	
	//TODO Methods here ...
}
