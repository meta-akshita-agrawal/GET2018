package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	public void deleteProjectById(int id);
	public Project findProjectById(int id);
}
