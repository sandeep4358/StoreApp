package com.card.SpringSecurityCardApp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.card.SpringSecurityCardApp.model.Employee;

public class MyUserDetails implements UserDetails {
	private final Logger log = LoggerFactory.getLogger(MyUserDetails.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fistName;
	private String Password;
	private boolean accountExp;
	private boolean accountLock;
	private boolean credentialExp;
	private boolean isEnable;
	private List<GrantedAuthority> authorities;

	MyUserDetails(Employee emp) {
		log.info("entry");
		fistName = emp.getFirstName();
		Password = emp.getPassword();
		accountExp = emp.isActive();
		accountLock = true;
		credentialExp = true;
		isEnable = true;
		authorities = Arrays.stream(emp.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// SimpleGranted

		// return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return Password;
	}

	@Override
	public String getUsername() {
		return fistName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountExp;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountLock;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialExp;
	}

	@Override
	public boolean isEnabled() {
		return isEnable;
	}

}
