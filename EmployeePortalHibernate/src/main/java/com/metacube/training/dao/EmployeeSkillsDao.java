package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.EmployeeSkills;


public interface EmployeeSkillsDao extends BaseDao<EmployeeSkills>{
	public List<EmployeeSkills> getSkillsByEmployeeId(int id);
	public boolean insertSkillsForEmployeeID(String[] skills,int id);
}
