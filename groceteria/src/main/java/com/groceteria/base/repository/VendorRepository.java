package com.groceteria.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.GroceteriaVendor;

public interface VendorRepository extends JpaRepository<GroceteriaVendor, Long> {

	Optional<GroceteriaVendor> findByUsername(String username);
}
