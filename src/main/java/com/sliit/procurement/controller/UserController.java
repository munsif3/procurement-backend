package com.sliit.procurement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.sliit.procurement.service.EmployeeService;
import com.sliit.procurement.service.UserService;
import com.sliit.procurement.Util.CustomErrorType;
import com.sliit.procurement.model.Department;
import com.sliit.procurement.model.Employee;
import com.sliit.procurement.model.Project;
import com.sliit.procurement.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("name") String name) {
		Employee employee = employeeService.findByUserName(name);
		if (employee == null) {
			return new ResponseEntity(new CustomErrorType("User with name " + name + " not found"),
					HttpStatus.NOT_FOUND);
		}
		User user = userService.findById(employee.getPersonNo());
		if (user == null) {
			return new ResponseEntity(new CustomErrorType("User with name " + name + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
		
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	 public ResponseEntity<User>addUser(@Valid @RequestBody User user) {
		 user= userService.addUser(user);
		 user.setPersonId("PER" + String.format("%03d", user.getPersonNo()));
		 user=userService.addUser(user);
	     return new ResponseEntity<User>(user,HttpStatus.CREATED);
	 }
	
	@PutMapping("/user")
	 public ResponseEntity<User>updateUser(@Valid @RequestBody User user) {
		 User userOld = userService.findById(user.getPersonNo());
		 if(user.getName()!=null){
			 userOld.setName(user.getName());
		 }
		 if(user.getNic()!=null){
			 userOld.setNic(user.getNic());
		 }
		 if(user.getContactNo()>0){
			 userOld.setContactNo(user.getContactNo());
		 }
		 if(user.getEmail()!=null){
			 userOld.setEmail(user.getEmail());
		 }
		 user=userService.addUser(user);
	     return new ResponseEntity<User>(user,HttpStatus.CREATED);
	 }

}
