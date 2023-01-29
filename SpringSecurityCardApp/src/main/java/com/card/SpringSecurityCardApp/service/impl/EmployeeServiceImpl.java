package com.card.SpringSecurityCardApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.SpringSecurityCardApp.common.RequestData;
import com.card.SpringSecurityCardApp.common.ResponseData;
import com.card.SpringSecurityCardApp.model.Employee;
import com.card.SpringSecurityCardApp.repo.EmployeeRepo;
import com.card.SpringSecurityCardApp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepo repository;

	@Override
	public ResponseData getEmployeeDetails(String employeeId) {
		log.info("entry");
		Employee employee = new Employee();
		ResponseData response = new ResponseData("Failure", "01", employee);

		try {
			Optional<Employee> fetchEmployee = repository.findById(Long.parseLong(employeeId));
			if (fetchEmployee.isPresent()) {
				employee = fetchEmployee.get();
				response.setData(employee);
				response.setMessage("successful");
				response.setStatus("00");
				log.info(response.toString());
			}

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus("00");
			log.error(e.getMessage());
		}
		log.info("exit");

		return response;

	}

	@Override
	public ResponseData saveEmployeeDetails(RequestData request) {
		ResponseData response = new ResponseData("Failure", "01", null);
		try {

			Employee employee = new Employee();
			employee.setFirstName(request.getFirstName());
			employee.setLastname(request.getLastName());
			employee.setAge(request.getAge());
			employee.setPhoneNumber(request.getPhoneNo());
			employee.setEmail(request.getEmail());

			Employee employee2 = repository.save(employee);

			if (employee2 != null) {
				response.setData(employee2);
				response.setMessage("successful");
				response.setStatus("00");
			}

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus("00");
		}

		return response;
	}

	@Override
	public ResponseData getAllEmployee() {
		log.info("entry");
		List<Employee> employeeList = new ArrayList<Employee>();
		ResponseData response = new ResponseData("Failure", "01", employeeList);

		try {
			Iterable<Employee> emp = repository.findAll();
			for (Employee employee2 : emp) {
				employeeList.add(employee2);
			}

			response.setData(employeeList);
			response.setMessage("success");
			response.setStatus("00");

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus("00");
			log.error(e.getMessage());
		}
		log.info("exit");

		return response;

	}

}
