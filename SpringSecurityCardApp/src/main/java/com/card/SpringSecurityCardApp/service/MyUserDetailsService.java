package com.card.SpringSecurityCardApp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.card.SpringSecurityCardApp.model.Employee;
import com.card.SpringSecurityCardApp.repo.EmployeeRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Autowired
	EmployeeRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("entry UserName : " + username);
		// TODO Auto-generated method stub
		Optional<Employee> employee = repo.findByFirstName(username);
		// employee.orElseThrow(()-> new UsernameNotFoundException("Not Found :
		// "+username));
		if (employee.isPresent()) {
			employee.get();
		} else {
			log.info("Not Found : " + username);
			throw new UsernameNotFoundException("Not Found : " + username);
		}

		log.info("exit");
		return employee.map(MyUserDetails::new).get();
	}

}
