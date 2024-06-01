package com.groceteria.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.GroceteriaUser;
import com.groceteria.base.model.GroceteriaUserAddress;

public interface AddressRepository extends JpaRepository<GroceteriaUserAddress, Long> {
    Optional<GroceteriaUserAddress> findByUser(GroceteriaUser user);
}
