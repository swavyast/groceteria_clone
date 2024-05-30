package com.groceteria.base.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.groceteria.base.dto.DtoGroceteriaUser;
import com.groceteria.base.enums.Gender;
import com.groceteria.base.enums.UserRole;
import com.groceteria.base.model.GroceteriaUser;
import com.groceteria.base.model.GroceteriaUserAddress;
import com.groceteria.base.model.GroceteriaUserControllerResponse;
import com.groceteria.base.repository.GroceteriaUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroceteriaUserService implements UserDetailsService {

	private final GroceteriaUserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<GroceteriaUser> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isPresent()) {

			return optionalUser.get();
		}

		throw new UsernameNotFoundException(
				String.format("User can not be found for the given username/email : %s", email));
	}

	public GroceteriaUserControllerResponse registerUser(DtoGroceteriaUser userData) {

		if (userRepository.findByEmail(userData.email()).isPresent()) {

			return new GroceteriaUserControllerResponse(
					String.format("This email id %s is already registered", userData.email()), HttpStatus.BAD_REQUEST,
					new GroceteriaUser());
		}

		GroceteriaUser user = new GroceteriaUser();
		user.setFirstName(userData.firstName());
		user.setMiddleName(userData.middleName());
		user.setLastName(userData.lastName());
		user.setGender(Gender.valueOf(userData.gender().toUpperCase()));
		user.setContacts(Arrays.asList(userData.phone()));
		user.setEmail(userData.email());
		user.setPassword(passwordEncoder.encode(userData.password()));
		user.setAvatar("");
		user.setEnabled(false);
		user.setLocked(false);
		user.setAddresses(Collections.emptyList());
		user.setRole(UserRole.USER);

		GroceteriaUser savedInstance = userRepository.save(user);

		return new GroceteriaUserControllerResponse(
				String.format("Registered Successfully. Your username is %s : ", userData.email()), HttpStatus.OK,
				savedInstance);
	}

}
