package com.metacube.training.dao;

import com.metacube.training.model.Job;

public interface JobDao extends BaseDao<Job>{
	
	public Job getJobByID(int id);
}
