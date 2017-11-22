package com.sliit.procurement.service;

import java.util.List;

import com.sliit.procurement.model.Employee;

public interface EmployeeService {
	 Employee findByUserName(String userName);
	 Employee addEmployee(Employee employee);
	 List<Employee> getAllEmployees();
	 Employee getEmployee(int id);
}
