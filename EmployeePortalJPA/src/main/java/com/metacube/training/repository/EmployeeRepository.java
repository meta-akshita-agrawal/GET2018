package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
