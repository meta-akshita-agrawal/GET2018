package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.metacube.training.model.Job;
import com.metacube.training.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{

//	@Autowired
//	JobDao jobDao;
	
	@Autowired
	JobRepository jobRepository;
	
	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public boolean deleteJob(int id) {
		try{
			jobRepository.deleteJobByJobCode(id);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

//	@Override
//	public boolean updateJob(Job job) {
//		return jobDao.update(job);
//	}

	@Override
	public boolean createJob(Job job) {
		try{
			jobRepository.save(job);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Job getJobById(int id) {
		return jobRepository.findJobByJobCode(id);
	}

}
