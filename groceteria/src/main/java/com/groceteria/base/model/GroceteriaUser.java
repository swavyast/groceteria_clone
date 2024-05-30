package com.groceteria.base.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.groceteria.base.enums.Gender;
import com.groceteria.base.enums.UserRole;

import lombok.Data;

@Data
@Entity
@Table
public class GroceteriaUser implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "mname")
    private String middleName;
    @Column(name = "lname")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ElementCollection
    private List<String> contacts;
    @OneToMany(mappedBy = "user")
    private List<GroceteriaUserAddress> addresses;
    private String email;
    private String password;
    private String avatar;
    private Boolean enabled;
    private Boolean locked;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return enabled;
    }

}
