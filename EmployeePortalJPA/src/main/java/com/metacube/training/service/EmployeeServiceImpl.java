package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int id) {
		return employeeRepository.deleteByEmployeeID(id)>0;
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) {
		try{
			employeeRepository.save(employee);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		try{
			employeeRepository.save(employee);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findEmployeeByEmployeeID(id);
	}

	@Override
	public List<Employee> searchEmployeeByName(String name) {
		return employeeRepository.findEmployeeByFirstName(name);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findEmployeeByEmailID(email);
	}

}
