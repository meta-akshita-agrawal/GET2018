package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
