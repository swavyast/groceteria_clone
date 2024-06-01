package com.groceteria.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // (debug = true)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable())
				.authorizeRequests(requests -> requests.antMatchers("/api/v*/admin/register", "/api/v*/admin/login")
						.permitAll().antMatchers("/admin/**", "/api/v*/admin/**").hasAnyAuthority("ADMIN")
						.antMatchers("/user/**").hasAnyAuthority("USER").antMatchers("/vendor/**", "/api/v*/vendors/**")
						.hasAnyAuthority("ADMIN", "VENDOR").antMatchers("/**").permitAll().anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").loginProcessingUrl("/api/v1/users/login")
						.defaultSuccessUrl("/**/**"))
				.logout(logout -> logout.permitAll().logoutSuccessUrl("/"));
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
