package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Job;

@Repository
@Transactional
public class MySQLJobDao implements JobDao{

	//private JdbcTemplate jdbcTemplate;
	
	/*
	@Autowired
	public MySQLJobDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//private static String SELECT_ALL_QUERY = "select * from employeeportal.job";
	//private static String INSERT_QUERY = "insert into employeeportal.job(title) values(?)";
	//private static String SELECT_BY_ID_QUERY = "select * from employeeportal.job where job_code=?";
	
	@Override
	public List<Job> getAll() {
		//return jdbcTemplate.query(SELECT_ALL_QUERY, new JobMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Job> criteria = builder.createQuery(Job.class);
		Root<Job> jobRoot = criteria.from(Job.class);
		criteria.select(jobRoot);
		
		List<Job> jobs = session.createQuery(criteria).getResultList();
		
		session.close();
		return jobs;
	}

	@Override
	public boolean insert(Job job) {
		
		Session session = sessionFactory.openSession();
		
		try{
			
			session.save(job);
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
		return true;

		
	}

	@Override
	public boolean update(Job entity) {
		return false;
	}

	@Override
	public boolean delete(Job entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Job getJobByID(int id) {
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Job> criteria = builder.createQuery(Job.class);
        Root<Job> jobRoot = criteria.from(Job.class);
        criteria.select(jobRoot);
        criteria.where(builder.equal(jobRoot.get("id"), id));
		
        Job job = session.createQuery(criteria).getSingleResult();
		
		session.close();
		
		return job;
	}

	
}
