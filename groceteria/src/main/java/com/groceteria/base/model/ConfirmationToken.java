package com.groceteria.base.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class ConfirmationToken {

	@Id
	@SequenceGenerator(name = "token_sequence", sequenceName = "token_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_sequence")
	private Long id;
	@Column(nullable = false)
	private String token;
	private LocalDateTime createdAt;
	private LocalDateTime confirmedAt;
	private LocalDateTime expiresAt;
	@ManyToOne
	@JoinColumn(name = "groceteria_user_id")
	private GroceteriaUser user;
}
