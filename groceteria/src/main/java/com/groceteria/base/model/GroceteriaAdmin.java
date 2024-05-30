package com.groceteria.base.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.groceteria.base.enums.UserRole;

import lombok.Data;

@Data
@Entity
@Table
public class GroceteriaAdmin implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sequence")
	@SequenceGenerator(name = "admin_sequence", sequenceName = "admin_sequence", allocationSize = 1)
	private Long id;
	private String name;
	private String username;
	private String password;
	private UserRole role;
	private Boolean isAccountExpired;
	private Boolean isAccountLocked;
	private Boolean isEnabled;
	private Boolean isCredentialExpired;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(role.name());

		return Collections.singletonList(authorities);
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return !getIsAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {

		return !getIsAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return getIsCredentialExpired();
	}

	@Override
	public boolean isEnabled() {

		return getIsEnabled();
	}

}
