package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.ProductCatagory;

public interface ProductCatagoryRepository extends JpaRepository<ProductCatagory, Long> {

}
