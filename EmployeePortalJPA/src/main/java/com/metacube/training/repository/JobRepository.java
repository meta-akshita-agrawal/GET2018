package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

	@Modifying
	@Query("delete from Job where jobCode=?1")
	public int deleteJobByJobCode(int jobCode);
	
	public Job findJobByJobCode(int jobCode);
}
