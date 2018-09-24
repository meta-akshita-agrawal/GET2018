package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService{

//	@Autowired
//	EmployeeSkillsDao myEmpSkillsDao;
	
	@Autowired
	EmployeeSkillsRepository employeeSkillsRepository;
	
	
	@Override
	@Transactional
	public List<EmployeeSkills> getAll() {
		return employeeSkillsRepository.findAll();
	}

	@Override
	@Transactional
	public boolean insertEmployeeSkill(EmployeeSkills entity) {
		try{
			employeeSkillsRepository.save(entity);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public List<EmployeeSkills> getSkillsByEmployeeId(int id) {
		return employeeSkillsRepository.findEmployeeSkillsByEmployeeID(id);
	}

	@Override
	@Transactional
	public boolean insertSkillsForEmployeeID(String[] skills, int id) {
		
		for(String skill:skills){
			EmployeeSkills employeeSkills = new EmployeeSkills();
			employeeSkills.setEmployeeID(id);
			employeeSkills.setSkillName(skill);
			boolean check = insertEmployeeSkill(employeeSkills);
			if(!check) return false;
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean deleteSkillsByEmployeeID(int id) {
		// TODO Auto-generated method stub
		return employeeSkillsRepository.deleteEmployeeSkillsByEmployeeID(id)>0;
	}

	@Override
	public List<Employee> findBySkillName(String skillName) {
		
		return employeeSkillsRepository.findBySkillName(skillName);
	}

}
