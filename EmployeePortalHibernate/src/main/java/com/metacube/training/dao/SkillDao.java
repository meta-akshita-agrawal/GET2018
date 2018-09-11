package com.metacube.training.dao;

import com.metacube.training.model.Skill;

public interface SkillDao extends BaseDao<Skill>{

	public Skill getSkillByID(int id);
}
