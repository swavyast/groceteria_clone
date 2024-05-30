package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.ConfirmationTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
	
	private final ConfirmationTokenRepository repository;
	
	// TODO Implement methods to manipulate with ConfirmationToken

}
