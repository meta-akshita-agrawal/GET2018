package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEmployeeID(resultSet.getInt("id"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender((String) resultSet.getObject("gender"));
		employee.setContactNumber(resultSet.getString("contact_no"));
		return employee;
	}
		

	
}
