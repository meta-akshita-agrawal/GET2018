package com.metacube.training.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Skill {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skillCode;
	
	@Column(name="name")
	private String skillName;
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="skill", cascade=CascadeType.ALL)
//	private List<EmployeeSkills> employeeSkills;
//	
//	public List<EmployeeSkills> getEmployeeSkills() {
//		return employeeSkills;
//	}
//	public void setEmployeeSkills(List<EmployeeSkills> employeeSkills) {
//		this.employeeSkills = employeeSkills;
//	}
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
