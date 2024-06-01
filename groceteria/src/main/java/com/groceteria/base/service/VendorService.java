package com.groceteria.base.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.groceteria.base.enums.UserRole;
import com.groceteria.base.model.GroceteriaVendor;
import com.groceteria.base.model.Shop;
import com.groceteria.base.records.DtoVendor;
import com.groceteria.base.records.VendorControllerResponse;
import com.groceteria.base.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorService {

	private final VendorRepository repository;

	public VendorControllerResponse registerVendor(DtoVendor vendorData) {

		if (repository.findByUsername(vendorData.username()).isPresent()) {

			return new VendorControllerResponse(
					String.format("Vendor is already registered with username %s ", vendorData.username()),
					HttpStatus.BAD_REQUEST, new GroceteriaVendor());
		}

		GroceteriaVendor newInstance = new GroceteriaVendor();
		newInstance.setName(vendorData.name());
		Shop shop1 = new Shop();
		shop1.setName(vendorData.shopName());
		newInstance.setShop(Arrays.asList(shop1));
		newInstance.setUsername(vendorData.username());
		newInstance.setPassword(vendorData.password());
		newInstance.setRole(UserRole.VENDOR);
		newInstance.setAvatar(vendorData.avatar());
		newInstance.setCode(UUID.randomUUID());
		newInstance.setCreatedAt(LocalDateTime.now());
		newInstance.setLastUpdatedAt(LocalDateTime.now());
		newInstance.setDeletedAt(null);
		newInstance.setIsActive(false);

		GroceteriaVendor savedInstance = repository.save(newInstance);

		return new VendorControllerResponse("Vendor has been registered successfully.", HttpStatus.CREATED,
				savedInstance);
	}

	// TODO Methods here...
}
