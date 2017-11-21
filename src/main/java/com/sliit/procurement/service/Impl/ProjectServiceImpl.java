package com.sliit.procurement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliit.procurement.model.Project;
import com.sliit.procurement.repository.ProjectRepository;
import com.sliit.procurement.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project getProject(int id) {
		return projectRepository.findOne(id);
	}

}
