package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
