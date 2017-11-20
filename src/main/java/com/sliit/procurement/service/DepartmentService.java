package com.sliit.procurement.service;
import java.util.List;

import com.sliit.procurement.model.Department;
public interface DepartmentService {
	List<Department> getAll();
	Department saveDepartment(Department department);
}
