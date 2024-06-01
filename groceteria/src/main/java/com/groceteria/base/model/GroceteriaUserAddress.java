package com.groceteria.base.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class GroceteriaUserAddress {

	@Id
	@SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
	private Long id;
	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String state;
	private String country;
	private Integer pincode;
	@ManyToOne
	private GroceteriaUser user;

}
