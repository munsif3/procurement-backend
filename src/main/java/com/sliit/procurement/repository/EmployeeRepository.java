package com.sliit.procurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sliit.procurement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	Employee findByUserName(String userName);
}
