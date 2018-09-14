package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService{

	List<Skill> getAllSkills();

	boolean deleteSkill(int id);

	//boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);

	Skill getSkillByID(int id);
}
