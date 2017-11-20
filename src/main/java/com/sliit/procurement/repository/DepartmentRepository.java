package com.sliit.procurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sliit.procurement.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
