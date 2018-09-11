package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.MySQLJobDao;
import com.metacube.training.model.Job;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	MySQLJobDao jobDao;
	
	@Override
	public List<Job> getAllJobs() {
		return jobDao.getAll();
	}

	@Override
	public boolean deleteJob(int id) {
		Job job = jobDao.getJobByID(id);
		return jobDao.delete(job);
	}

	@Override
	public boolean updateJob(Job job) {
		return jobDao.update(job);
	}

	@Override
	public boolean createJob(Job job) {
		return jobDao.insert(job);
	}

	@Override
	public Job getJobById(int id) {
		return jobDao.getJobByID(id);
	}

}
