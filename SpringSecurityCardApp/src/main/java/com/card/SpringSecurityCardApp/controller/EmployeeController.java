package com.card.SpringSecurityCardApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.SpringSecurityCardApp.common.RequestData;
import com.card.SpringSecurityCardApp.common.ResponseData;
import com.card.SpringSecurityCardApp.service.EmployeeService;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/test/{request}")
	public ResponseData testEmployee(@PathVariable String request) {
		return new ResponseData("Employee Success test", "00", request);
	}

	@PostMapping(path = "/addEmployee")
	public ResponseData addEmployee(@RequestBody RequestData request) {
		return service.saveEmployeeDetails(request);
	}

	@GetMapping(path = "/getEmployee/{employeeId}")
	public ResponseData addEmployee(@PathVariable String employeeId) {
		return service.getEmployeeDetails(employeeId);
	}

	@GetMapping(path = "/allEmployeeList")
	public ResponseData fetchAllEmployee() {
		return service.getAllEmployee();
	}

}
