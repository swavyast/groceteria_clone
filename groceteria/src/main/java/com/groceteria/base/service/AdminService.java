package com.groceteria.base.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.groceteria.base.enums.UserRole;
import com.groceteria.base.exception.InstantiationFailedException;
import com.groceteria.base.factory.EmptyInstance;
import com.groceteria.base.model.GroceteriaAdmin;
import com.groceteria.base.records.AdminControllerResponse;
import com.groceteria.base.records.DtoAdmin;
import com.groceteria.base.records.DtoLogin;
import com.groceteria.base.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

	private final AdminRepository adminRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final EmptyInstance<GroceteriaAdmin> emptyInstance;

	public AdminControllerResponse register(DtoAdmin userData) throws InstantiationFailedException {

		if (adminRepository.findByUsername(userData.username()).isPresent()) {

			return new AdminControllerResponse(
					String.format("An admin is already registered by the username %s", userData.username()),
					HttpStatus.CONFLICT, emptyInstance.forClass(GroceteriaAdmin.class));
		}

		GroceteriaAdmin newInstance = new GroceteriaAdmin();
		newInstance.setName(userData.name());
		newInstance.setUsername(userData.username());
		newInstance.setPassword(passwordEncoder.encode(userData.password()));
		newInstance.setIsAccountExpired(false);
		newInstance.setIsAccountLocked(false);
		newInstance.setRole(UserRole.ADMIN);
		newInstance.setIsEnabled(true);
		newInstance.setIsCredentialExpired(false);

		GroceteriaAdmin savedInstance = adminRepository.save(newInstance);
		return new AdminControllerResponse(
				String.format("Admin registered successfully with username %s ", userData.username()),
				HttpStatus.CREATED, savedInstance);
	}

	public AdminControllerResponse login(DtoLogin userData) throws InstantiationFailedException {

		Optional<GroceteriaAdmin> testAdmin = adminRepository.findByUsername(userData.username());
		if (testAdmin.isPresent()) {
			GroceteriaAdmin existingAdmin = testAdmin.get();
			if (passwordEncoder.matches(userData.password(), existingAdmin.getPassword())) {

				existingAdmin.setIsEnabled(true);
				adminRepository.save(existingAdmin);

				return new AdminControllerResponse("Dear admin, It's so nice to see you again.", HttpStatus.OK,
						existingAdmin);
			} else {

				return new AdminControllerResponse("Either username or password is incorrect", HttpStatus.UNAUTHORIZED,
						emptyInstance.forClass(GroceteriaAdmin.class));
			}

		} else {

			return new AdminControllerResponse(
					String.format("Admin details are not present for the given username %s and password %s combination",
							userData.username(), userData.password()),
					HttpStatus.NOT_FOUND, emptyInstance.forClass(GroceteriaAdmin.class));
		}

	}

}
