package com.sliit.procurement.service;

import java.util.List;

import com.sliit.procurement.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();
	Project addProject(Project project);
	Project getProject(int id);
}
