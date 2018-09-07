package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.model.Employee;

@Repository
public class MySQLEmployeeDao implements EmployeeDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MySQLEmployeeDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final String SELECT_QUERY= "select * from employeeportal.employee";
	private static final String INSERT_QUERY= "insert into employeeportal.employee(first_name,last_name,dob,gender,contact_no,email_id) values (?,?,?,?,?,?)";
	private static final String UPDATE_QUERY = "update employeeportal.employee set first_name=?, last_name=?, dob=?, gender=?, contact_no=?,email_id=? where id=?";
	private static final String DELETE_QUERY = "delete from employeeportal.employee where id=?";
	private static final String SELECT_BY_ID_QUERY = "select *  from employeeportal.employee where id = ?";
	private static final String SELECT_BY_NAME_QUERY = "select * from employeeportal.employee where first_name=?";
	
	
	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query(SELECT_QUERY, new EmployeeMapper());
	}

	@Override
	public boolean insert(Employee employee) {
		return jdbcTemplate.update(INSERT_QUERY,employee.getFirstName(), employee.getLastName(), employee.getDob(),employee.getGender(), employee.getContactNumber(), employee.getEmailID()) > 0;
	}

	@Override
	public boolean update(Employee employee) {
		return jdbcTemplate.update(UPDATE_QUERY, employee.getFirstName(), employee.getLastName(), employee.getDob(), employee.getGender(), employee.getContactNumber() ,employee.getEmployeeID()) > 0;
	}

	@Override
	public boolean delete(Employee employee) {
		return jdbcTemplate.update(DELETE_QUERY, employee.getEmployeeID()) > 0;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[]{id}, new EmployeeMapper());
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return jdbcTemplate.query(SELECT_BY_NAME_QUERY, new Object[] {name}, new EmployeeMapper());
	}

	
}
