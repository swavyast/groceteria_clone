package com.groceteria.base.service;

import org.springframework.stereotype.Service;

import com.groceteria.base.repository.TokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService {
	
	private final TokenRepository repository;
	
	// TODO Implement methods to manipulate with ConfirmationToken

}
