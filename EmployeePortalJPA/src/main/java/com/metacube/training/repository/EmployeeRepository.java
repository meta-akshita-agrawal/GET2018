package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Modifying
	@Query("delete from Employee where employeeID=?1")
	public int deleteByEmployeeID(int employeeID);
	
	public Employee findEmployeeByEmployeeID(int employeeID);
	
	public List<Employee> findEmployeeByFirstName(String firstName);
	
	public Employee findEmployeeByEmailID(String emailID);
	
	
}
