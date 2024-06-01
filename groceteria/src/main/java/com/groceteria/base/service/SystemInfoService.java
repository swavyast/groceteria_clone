package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.SystemInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemInfoService {

	private final SystemInfoRepository repository;
	
	//TODO Methods ...
}
