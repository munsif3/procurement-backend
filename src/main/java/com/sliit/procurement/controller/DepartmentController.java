package com.sliit.procurement.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.sliit.procurement.model.Department;
import com.sliit.procurement.model.User;
import com.sliit.procurement.service.DepartmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/departments/", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> listAllUsers() {
        List<Department> departments = departmentService.getAll();
        if (departments.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
    }
	
	@PostMapping("/department")
	 public ResponseEntity<Department>createNote(@Valid @RequestBody Department department) {
		 department= departmentService.saveDepartment(department);
		 department.setDepartmentId("DEP" + String.format("%03d", department.getDepartmentNo()));
		 department=departmentService.saveDepartment(department);
	     return new ResponseEntity<Department>(department,HttpStatus.CREATED);
	 }
	
	@PutMapping("/department/{id}/{name}")
	 public ResponseEntity<Department>updateDepartment(@PathVariable("id")int id,@PathVariable("name")String name) {
		 Department department= departmentService.getById(id);
		 department.setDepartmentName(name);
		 department=departmentService.saveDepartment(department);
	     return new ResponseEntity<Department>(department,HttpStatus.CREATED);
	 }
}
