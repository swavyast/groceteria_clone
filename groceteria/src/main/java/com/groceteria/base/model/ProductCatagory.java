package com.groceteria.base.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class ProductCatagory {

	@Id
	@SequenceGenerator(name = "catagory_sequence", sequenceName = "catagory_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catagory_sequence")
	private Long id;
	private String name;
	private String description;
	private Boolean isAvailable;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;
	private LocalDateTime deletedAt;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catagory")
	private List<Product> productList;

}
