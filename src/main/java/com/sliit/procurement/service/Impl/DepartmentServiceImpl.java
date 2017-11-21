package com.sliit.procurement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliit.procurement.model.Department;
import com.sliit.procurement.repository.DepartmentRepository;
import com.sliit.procurement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
    
	@Override
	public Department getById(int id) {
		return departmentRepository.findOne(id);
	}
}
