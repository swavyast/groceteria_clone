package com.groceteria.base.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Shop {

	@Id
	@SequenceGenerator(name = "shop_sequence", sequenceName = "shop_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_sequence")
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "shop")
	private List<GroceteriaVendor> ownedBy;
}
