package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class MySQLProjectDao implements ProjectDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MySQLProjectDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static String SELECT_ALL_QUERY = "select * from employeeportal.project";
	private static String INSERT_QUERY = "insert into employeeportal.project(description,start_date,end_date) values(?,?,?)";
	private static String UPDATE_QUERY ="update employeeportal.project set description =?, start_date =?, end_date=? where id=?";
	private static String DELETE_QUERY = "delete from employeeportal.project where id= ?";
	private static String SELECT_BY_ID_QUERY = "select * from employeeportal.project where id=?";

	@Override
	public List<Project> getAll() {
		return jdbcTemplate.query(SELECT_ALL_QUERY, new ProjectMapper());
	}

	@Override
	public boolean insert(Project project) {
		return jdbcTemplate.update(INSERT_QUERY, project.getDescription(),project.getStartDate(),project.getEndDate()) > 0;
	}

	@Override
	public boolean update(Project project) {
		return jdbcTemplate.update(UPDATE_QUERY, project.getDescription(),project.getStartDate(),project.getEndDate(),project.getId())>0;
	}

	@Override
	public boolean delete(Project project) {
		return jdbcTemplate.update(DELETE_QUERY, project.getId())>0;
	}

	@Override
	public Project getProjectByID(int id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[]{id}, new ProjectMapper());
	}

}
