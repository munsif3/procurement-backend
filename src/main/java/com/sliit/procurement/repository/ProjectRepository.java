package com.sliit.procurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sliit.procurement.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
