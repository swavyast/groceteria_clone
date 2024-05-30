package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
