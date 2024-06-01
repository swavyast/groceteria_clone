package com.groceteria.base.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.groceteria.base.enums.UserRole;

import lombok.Data;

@Data
@Entity
@Table
public class GroceteriaVendor {

	@Id
	@SequenceGenerator(name = "vendor_sequence", sequenceName = "vendor_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_sequence")
	private Long id;
	private UUID code;
	private String name;
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;
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