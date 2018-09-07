package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.dao.ProjectDao;
import com.metacube.training.model.Project;

public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<Project> getAllProjects() {
		return projectDao.getAll();
	}

	@Override
	public boolean deleteProject(int id) {
		Project project = projectDao.getProjectByID(id);
		return projectDao.delete(project);
	}

	@Override
	public boolean updateProject(Project project) {
		return projectDao.update(project);
	}

	@Override
	public boolean createProject(Project project) {
		return projectDao.insert(project);
	}

	@Override
	public Project getProjectById(int id) {
		return projectDao.getProjectByID(id);
	}

	

}
