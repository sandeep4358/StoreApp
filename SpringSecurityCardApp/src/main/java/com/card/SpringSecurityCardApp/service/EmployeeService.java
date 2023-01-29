package com.card.SpringSecurityCardApp.service;

import com.card.SpringSecurityCardApp.common.RequestData;
import com.card.SpringSecurityCardApp.common.ResponseData;


public interface EmployeeService {
	
	public ResponseData getEmployeeDetails(String employeeId);
	public ResponseData saveEmployeeDetails(RequestData request);
	public ResponseData getAllEmployee();

  
}
