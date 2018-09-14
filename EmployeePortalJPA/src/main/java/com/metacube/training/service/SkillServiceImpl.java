package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService{

//	@Autowired
//	SkillDao skillDao;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Override
	@Transactional
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteSkill(int id) {
		return skillRepository.deleteSkillBySkillCode(id) > 0;
	}

//	@Override
//	public boolean updateSkill(Skill skill) {
//		return skillDao.update(skill);
//	}

	@Override
	@Transactional
	public boolean createSkill(Skill skill) {
		try{
			skillRepository.save(skill);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public Skill getSkillByID(int id) {
		return skillRepository.findSkillBySkillCode(id);
	}

}
