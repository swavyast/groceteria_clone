package com.groceteria.base.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private String imagePath;
	private Boolean status;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;
	@ManyToOne
	@JoinColumn(name = "productList")
	private ProductCatagory catagory;
	@ManyToMany(mappedBy = "catalog")
	private List<GroceteriaVendor> vendor;

}