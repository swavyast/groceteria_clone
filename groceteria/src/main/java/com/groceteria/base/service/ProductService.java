package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	
	//TODO Methods here ...
}
