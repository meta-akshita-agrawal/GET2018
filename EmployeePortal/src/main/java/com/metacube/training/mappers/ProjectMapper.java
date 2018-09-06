package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Project;

public class ProjectMapper implements RowMapper<Project>{

	@Override
	public Project mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Project project = new Project();
		project.setId(resultSet.getInt("id"));
		project.setDescription(resultSet.getString("description"));
		project.setStart_date(resultSet.getDate("start_date"));
		project.setEnd_date(resultSet.getDate("end_date"));
		return project;
	}

}
