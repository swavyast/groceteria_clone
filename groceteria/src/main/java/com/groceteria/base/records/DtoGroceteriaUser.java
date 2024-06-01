package com.groceteria.base.records;

public record DtoGroceteriaUser(
		String firstName,
		String middleName,
		String lastName,
		String gender,
		String phone,
		String email,
		String password) 
{}
