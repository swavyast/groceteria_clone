package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.ProductCatagory;

public interface CatagoryRepository extends JpaRepository<ProductCatagory, Long> {

}
