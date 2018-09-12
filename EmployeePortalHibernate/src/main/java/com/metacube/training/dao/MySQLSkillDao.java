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

import com.metacube.training.model.Skill;

@Repository
@Transactional
public class MySQLSkillDao implements SkillDao{

	//private JdbcTemplate jdbcTemplate;
	
	/*
	@Autowired
	public MySQLSkillDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	//private static String SELECT_ALL_QUERY = "select * from employeeportal.skill";
	//private static String INSERT_QUERY = "insert into employeeportal.skill(name) values(?)";
	//private static String SELECT_BY_ID_QUERY = "select * from employeeportal.skill where id=?";

	
	@Override
	public List<Skill> getAll() {
		//return jdbcTemplate.query(SELECT_ALL_QUERY, new SkillMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
        Root<Skill> projectRoot = criteria.from(Skill.class);
        criteria.select(projectRoot);
		
        List<Skill> skills = session.createQuery(criteria).getResultList();
		
		session.close();
   
		return skills;
	}

	@Override
	public boolean insert(Skill skill) {
		
		Session session = sessionFactory.openSession();
		
		
		try{
			
			session.save(skill);
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
        return true;
	}

	@Override
	public boolean update(Skill entity) {
		return false;
	}

	@Override
	public boolean delete(Skill entity) {
		return false;
	}

	@Override
	public Skill getSkillByID(int id) {
		//return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[] {id}, new SkillMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
        Root<Skill> skillRoot = criteria.from(Skill.class);
        criteria.select(skillRoot);
        criteria.where(builder.equal(skillRoot.get("id"), id));
		
        Skill skill = session.createQuery(criteria).getSingleResult();
		
		session.close();
		
		return skill;
	}


}
