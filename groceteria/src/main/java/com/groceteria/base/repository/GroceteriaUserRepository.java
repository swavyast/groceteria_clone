package com.groceteria.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.GroceteriaUser;

public interface GroceteriaUserRepository extends JpaRepository<GroceteriaUser, Long> {

    Optional<GroceteriaUser> findByEmail(String email);

}
