package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.dao.EmployeeDao;
import com.metacube.training.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAll();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee = employeeDao.getEmployeeByID(id);
		return employeeDao.delete(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDao.update(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return employeeDao.insert(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeByID(id);
	}

}
