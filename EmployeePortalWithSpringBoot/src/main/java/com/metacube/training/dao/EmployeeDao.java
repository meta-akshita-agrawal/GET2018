package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDao extends BaseDao<Employee>{
	
	public Employee getEmployeeByID(int id);
	public List<Employee> getEmployeeByName(String name);
}
