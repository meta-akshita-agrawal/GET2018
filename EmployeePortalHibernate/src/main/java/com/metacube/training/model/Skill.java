package com.metacube.training.model;

import javax.persistence.*;

@Entity
public class Skill {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skillCode;
	
	@Column(name="name")
	private String skillName;
	
	public int getSkillCode() {
		return skillCode;
	}
	public void setSkillCode(int skillCode) {
		this.skillCode = skillCode;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillName() {
		return skillName;
	}
	
}
