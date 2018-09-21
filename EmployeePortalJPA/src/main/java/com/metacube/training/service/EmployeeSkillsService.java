package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillsService {
	
	public List<EmployeeSkills> getAll();
	public boolean insertEmployeeSkill(EmployeeSkills entity);
	public List<EmployeeSkills> getSkillsByEmployeeId(int id);
	public boolean insertSkillsForEmployeeID(String[] skills,int id);
	public boolean deleteSkillsByEmployeeID(int id);
	public List<Employee> findBySkillName(String skillName);
}
