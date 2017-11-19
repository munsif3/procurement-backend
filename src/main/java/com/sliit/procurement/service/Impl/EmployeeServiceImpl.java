package com.sliit.procurement.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliit.procurement.model.Employee;
import com.sliit.procurement.repository.EmployeeRepository;
import com.sliit.procurement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee findByUserName(String userName) {
		return  employeeRepository.findByUserName(userName);
	}

}
