package com.metacube.training.model;

import javax.persistence.*;

@Entity
@Table(name="employee_skills")
public class EmployeeSkills {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="employee_code")
	private int employeeID;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="skill_name")
	private String skillName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//	public Skill getSkill() {
//		return skill;
//	}
//	public void setSkill(Skill skill) {
//		this.skill = skill;
//	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
}
