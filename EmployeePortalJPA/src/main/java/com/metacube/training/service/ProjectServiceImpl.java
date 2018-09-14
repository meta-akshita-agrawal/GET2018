package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	/*@Autowired
	private ProjectDao projectDao;*/
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteProject(int id) {
		try{
			projectRepository.deleteProjectByid(id);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	@Transactional
	public boolean updateProject(Project project) {
		try{
			projectRepository.save(project);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public boolean createProject(Project project) {
		try{
			projectRepository.save(project);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public Project getProjectById(int id) {
		return projectRepository.findProjectById(id);
	}

	

}
