package com.card.SpringSecurityCardApp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.card.SpringSecurityCardApp.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
}
