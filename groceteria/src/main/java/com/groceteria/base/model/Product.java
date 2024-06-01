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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Product {

	@Id
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
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