package com.sliit.procurement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.procurement.Util.CustomErrorType;
import com.sliit.procurement.model.Employee;
import com.sliit.procurement.model.Project;
import com.sliit.procurement.model.User;
import com.sliit.procurement.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employees/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllProjects() {
		List<Employee> employees = employeeService.getAllEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> addUser(@Valid @RequestBody Employee employee) {
		employee = employeeService.addEmployee(employee);
		employee.setEmployeeId("EMP" + String.format("%03d", employee.getPersonNo()));
		employee.setPersonId("PER" + String.format("%03d", employee.getPersonNo()));
		employee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {

		Employee employee = employeeService.getEmployee(id);
		if (employee == null) {
			return new ResponseEntity(new CustomErrorType("Employee with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(employee, HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {	
		Employee employeeOld = employeeService.getEmployee(employee.getPersonNo());
		if(employee.getUserName()!=null){
			employeeOld.setUserName(employee.getUserName());
		 }
		 if(employee.getPassword()!=null){
			employeeOld.setPassword(employee.getPassword());
		 }
		 if(employee.getDepartment()!=null){
			employeeOld.setDepartment(employee.getDepartment());
		 }
		 if(employee.getDesignation()!=null){
			 employeeOld.setDesignation(employee.getDesignation());
		 }
		 if(employee.getProject()!=null){
			 employeeOld.setProject(employee.getProject());
		 }
		 employeeOld = employeeService.addEmployee(employeeOld);
		return new ResponseEntity<Employee>(employeeOld, HttpStatus.CREATED);
	}

}
