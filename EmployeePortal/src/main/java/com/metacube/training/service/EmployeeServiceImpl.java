package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.MySQLEmployeeDao;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	MySQLEmployeeDao employeeDao;
	
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

	@Override
	public List<Employee> searchEmployeeByName(String name) {
		return employeeDao.getEmployeeByName(name);
	}

}
