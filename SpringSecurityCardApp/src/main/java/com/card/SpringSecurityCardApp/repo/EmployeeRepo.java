package com.card.SpringSecurityCardApp.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.card.SpringSecurityCardApp.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	
	public Optional<Employee> findByFirstName(String firstName);
	
}
