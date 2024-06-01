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

import com.groceteria.base.enums.Gender;
import com.groceteria.base.enums.UserRole;
import com.groceteria.base.model.GroceteriaUser;
import com.groceteria.base.records.DtoGroceteriaUser;
import com.groceteria.base.records.UserControllerResponse;
import com.groceteria.base.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
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

	public UserControllerResponse registerUser(DtoGroceteriaUser userData) {

		if (userRepository.findByEmail(userData.email()).isPresent()) {

			return new UserControllerResponse(
					String.format("A user is already registered with username %s ", userData.email()),
					HttpStatus.BAD_REQUEST, new GroceteriaUser());
		}

		GroceteriaUser newInstance = new GroceteriaUser();
		newInstance.setFirstName(userData.firstName());
		newInstance.setMiddleName(userData.middleName());
		newInstance.setLastName(userData.lastName());
		newInstance.setGender(Gender.valueOf(userData.gender().toUpperCase()));
		newInstance.setContacts(Arrays.asList(userData.phone()));
		newInstance.setEmail(userData.email());
		newInstance.setPassword(passwordEncoder.encode(userData.password()));
		newInstance.setAvatar("");
		newInstance.setEnabled(false);
		newInstance.setLocked(false);
		newInstance.setAddresses(Collections.emptyList());
		newInstance.setRole(UserRole.USER);

		GroceteriaUser savedInstance = userRepository.save(newInstance);

		return new UserControllerResponse(
				String.format("Registered Successfully. Your username is %s : ", userData.email()), HttpStatus.OK,
				savedInstance);
	}

}
