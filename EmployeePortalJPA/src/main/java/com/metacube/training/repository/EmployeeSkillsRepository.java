package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.EmployeeSkills;

@Repository
public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Long>{

	@Modifying
	@Query("delete from EmployeeSkills where employeeID=?1")
	public int deleteEmployeeSkillsByEmployeeID(int employeeID);
	
	public List<EmployeeSkills> findEmployeeSkillsByEmployeeID(int employeeID);
}
