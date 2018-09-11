package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeSkillsMapper;
import com.metacube.training.model.EmployeeSkills;

@Repository
public class MySQLEmployeeSkillsDao implements EmployeeSkillsDao{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MySQLEmployeeSkillsDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final String SELECT_QUERY="select * from employeeportal.employee_skills";
	private static final String INSERT_QUERY="insert into employeeportal.employee_skills(employee_code,skill_name) values(?,?) ";
	private static final String GET_SKILL_BY_EMPLOYEE_ID_QUERY = "select * from employeeportal.employee_skills where employee_code=?";
	
	@Override
	public List<EmployeeSkills> getAll() {
		return jdbcTemplate.query(SELECT_QUERY, new EmployeeSkillsMapper());
	}

	@Override
	public boolean insert(EmployeeSkills entity) {
		return jdbcTemplate.update(INSERT_QUERY, entity.getEmployeeID(), entity.getSkillName()) > 0;
	}

	@Override
	public boolean update(EmployeeSkills entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EmployeeSkills entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeSkills> getSkillsByEmployeeId(int id) {
		return jdbcTemplate.query(GET_SKILL_BY_EMPLOYEE_ID_QUERY, new Object[]{id}, new EmployeeSkillsMapper());
	}

}
