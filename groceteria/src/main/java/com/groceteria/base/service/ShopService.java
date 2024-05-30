package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {

	private final ShopRepository repository;
	
	//TODO Methods here ...
}
