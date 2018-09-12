package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeSkillsDao;
import com.metacube.training.model.EmployeeSkills;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService{

	@Autowired
	EmployeeSkillsDao myEmpSkillsDao;
	
	@Override
	public List<EmployeeSkills> getAll() {
		return myEmpSkillsDao.getAll();
	}

	@Override
	public boolean insertEmployeeSkill(EmployeeSkills entity) {
		return myEmpSkillsDao.insert(entity);
	}

	@Override
	public List<EmployeeSkills> getSkillsByEmployeeId(int id) {
		return myEmpSkillsDao.getSkillsByEmployeeId(id);
	}

	@Override
	public boolean insertSkillsForEmployeeID(String[] skills, int id) {
		return myEmpSkillsDao.insertSkillsForEmployeeID(skills, id);
	}

}
