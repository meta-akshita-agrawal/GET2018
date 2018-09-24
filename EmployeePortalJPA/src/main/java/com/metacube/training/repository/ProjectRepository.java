package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Modifying
	@Query("delete from Project where id=?1")
	public int deleteProjectByid(int id);
	
	public Project findProjectById(int id);
}
