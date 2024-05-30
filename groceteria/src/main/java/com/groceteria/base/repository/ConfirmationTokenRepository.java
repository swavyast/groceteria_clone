package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

}
