package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeSkills;

public class EmployeeSkillsMapper implements RowMapper<EmployeeSkills>{

	@Override
	public EmployeeSkills mapRow(ResultSet resultSet, int i) throws SQLException {
		
		EmployeeSkills employeeSkills = new EmployeeSkills();
		employeeSkills.setEmployeeID(resultSet.getInt("employee_code"));
		employeeSkills.setSkillName(resultSet.getString("skill_name"));
		
		return employeeSkills;
	}

}
