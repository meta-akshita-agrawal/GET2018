package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

	@Modifying
	@Query("delete from Skill where skillCode=?1")
	public int deleteSkillBySkillCode(int skillCode);
	
	public Skill findSkillBySkillCode(int skillCode);
}
