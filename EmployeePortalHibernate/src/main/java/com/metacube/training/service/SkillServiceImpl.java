package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.metacube.training.dao.SkillDao;
import com.metacube.training.model.Skill;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	SkillDao skillDao;
	
	@Override
	public List<Skill> getAllSkills() {
		return skillDao.getAll();
	}

	@Override
	public boolean deleteSkill(int id) {
		Skill skill = skillDao.getSkillByID(id);
		return skillDao.delete(skill);
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return skillDao.update(skill);
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDao.insert(skill);
	}

	@Override
	public Skill getSkillByID(int id) {
		return skillDao.getSkillByID(id);
	}

}
