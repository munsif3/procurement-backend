package com.sliit.procurement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.procurement.service.EmployeeService;
import com.sliit.procurement.service.UserService;
import com.sliit.procurement.Util.CustomErrorType;
import com.sliit.procurement.model.Employee;
import com.sliit.procurement.model.User;
@RestController
@RequestMapping(path="/api")
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
	@RequestMapping(value = "/user/{name}", method =RequestMethod.GET)
	    public ResponseEntity<?> getUser(@PathVariable("name") String name) {
	        Employee employee = employeeService.findByUserName(name);
	        if (employee == null) {
	            return new ResponseEntity(new CustomErrorType("User with name " + name
	                    + " not found"), HttpStatus.NOT_FOUND);
	        }
	        User user = userService.findById(employee.getPersonNo());
	        if (user == null) {
	            return new ResponseEntity(new CustomErrorType("User with name " + name
	                    + " not found"), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	
	
}
