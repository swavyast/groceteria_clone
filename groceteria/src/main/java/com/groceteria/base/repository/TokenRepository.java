package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.ConfirmationToken;

public interface TokenRepository extends JpaRepository<ConfirmationToken, Long> {

}
