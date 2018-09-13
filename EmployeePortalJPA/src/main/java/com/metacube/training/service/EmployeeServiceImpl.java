package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDao;
import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee = employeeRepository.de
		return employeeDao.delete(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
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

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}

}
