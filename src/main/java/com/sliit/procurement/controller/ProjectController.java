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

import com.sliit.procurement.Util.CustomErrorType;
import com.sliit.procurement.model.Department;
import com.sliit.procurement.model.Project;
import com.sliit.procurement.service.ProjectService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/projects/", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> listAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		if (projects.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

	@PostMapping("/project")
	public ResponseEntity<Project> createNote(@Valid @RequestBody Project project) {
		project = projectService.addProject(project);
		project.setProjectId("PRO" + String.format("%03d", project.getProjectNo()));
		project = projectService.addProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public ResponseEntity<Project> getProject(@PathVariable("id")int id) {
		Project project = projectService.getProject(id);
		if (project == null) {
			 return new ResponseEntity(new CustomErrorType("Project with " + id
	                    + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	
	@PutMapping("/project")
	 public ResponseEntity<Project>updateProject(@Valid @RequestBody Project project) {
		 Project projectOld = projectService.getProject(project.getProjectNo());
		 if(project.getName()!=null){
			 projectOld.setName(project.getName());
		 }
		 if(project.getStartDate()!=null){
			 projectOld.setStartDate(project.getStartDate());
		 }
		 if(project.getEndDate()!=null){
			 projectOld.setEndDate(project.getEndDate());
		 }
		 if(project.getSite()!=null){
			 projectOld.setSite(project.getSite());
		 }
		 project=projectService.addProject(projectOld);
	     return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	 }
}
