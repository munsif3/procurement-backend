package com.sliit.procurement.service;

import com.sliit.procurement.model.Employee;

public interface EmployeeService {
	 Employee findByUserName(String userName);
}
