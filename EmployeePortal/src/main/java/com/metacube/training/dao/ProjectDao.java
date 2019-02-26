package com.metacube.training.dao;

import com.metacube.training.model.Project;


public interface ProjectDao extends BaseDao<Project>{
	
	public Project getProjectByID(int id);
}
