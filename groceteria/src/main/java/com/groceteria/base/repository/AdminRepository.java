package com.groceteria.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.GroceteriaAdmin;

public interface AdminRepository extends JpaRepository<GroceteriaAdmin, Long> {

	Optional<GroceteriaAdmin> findByUsername(String username);
}
