package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.JobMapper;
import com.metacube.training.model.Job;

@Repository
public class MySQLJobDao implements JobDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MySQLJobDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static String SELECT_ALL_QUERY = "select * from employeeportal.job";
	private static String INSERT_QUERY = "insert into employeeportal.job(title) values(?)";
	private static String SELECT_BY_ID_QUERY = "select * from employeeportal.job where job_code=?";
	
	@Override
	public List<Job> getAll() {
		return jdbcTemplate.query(SELECT_ALL_QUERY, new JobMapper());
	}

	@Override
	public boolean insert(Job job) {
		return jdbcTemplate.update(INSERT_QUERY, job.getTitle()) > 0;
	}

	@Override
	public boolean update(Job entity) {
		return false;
	}

	@Override
	public boolean delete(Job entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Job getJobByID(int id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[] {id}, new JobMapper());
	}

	
}
