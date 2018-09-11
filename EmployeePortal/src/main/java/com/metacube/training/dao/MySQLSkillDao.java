package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Skill;

@Repository
public class MySQLSkillDao implements SkillDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MySQLSkillDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static String SELECT_ALL_QUERY = "select * from employeeportal.skill";
	private static String INSERT_QUERY = "insert into employeeportal.skill(name) values(?)";
	private static String SELECT_BY_ID_QUERY = "select * from employeeportal.skill where id=?";

	
	@Override
	public List<Skill> getAll() {
		return jdbcTemplate.query(SELECT_ALL_QUERY, new SkillMapper());
	}

	@Override
	public boolean insert(Skill skill) {
		return jdbcTemplate.update(INSERT_QUERY, skill.getSkillName()) > 0;
	}

	@Override
	public boolean update(Skill entity) {
		return false;
	}

	@Override
	public boolean delete(Skill entity) {
		return false;
	}

	@Override
	public Skill getSkillByID(int id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[] {id}, new SkillMapper());
	}


}
