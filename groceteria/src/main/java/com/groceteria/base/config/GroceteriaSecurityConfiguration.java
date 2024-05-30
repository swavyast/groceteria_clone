package com.groceteria.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.groceteria.base.enums.UserRole;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity // (debug = true)
@RequiredArgsConstructor
public class GroceteriaSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable()).authorizeRequests(requests -> requests
				.antMatchers("/", "/register", "/login", "/logout", "/api/v*/users/register", "/api/v*/users/login")
				.permitAll().antMatchers("/api/v*/vendors/**", "/api/v*/admin/**").hasAnyRole(UserRole.ADMIN.name())
				.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/users/**/"))
				.logout(logout -> logout.permitAll().logoutSuccessUrl("/"));
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
