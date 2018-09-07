package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService{

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	Employee getEmployeeById(int id);
}
