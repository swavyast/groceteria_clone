package com.groceteria.base.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class GroceteriaVendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer code;
	private String name;
	private String username;
	private String password;
	private String avatar;
	private Boolean isActive;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;
	private LocalDateTime deletedAt;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "shop_and_owners", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "ownedBy"))
	private List<Shop> shop;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vendor_product_catalog", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "vendor"))
	private List<Product> catalog;

}