package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService{
	
	List<Job> getAllJobs();

	boolean deleteJob(int id);

	boolean updateJob(Job job);

	boolean createJob(Job job);
	
	Job getJobById(int id);
}
