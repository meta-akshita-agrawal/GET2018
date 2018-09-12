package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public class MySQLProjectDao implements ProjectDao{

	//private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public MySQLProjectDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//private static String SELECT_ALL_QUERY = "select * from employeeportal.project";
	//private static String INSERT_QUERY = "insert into employeeportal.project(description,start_date,end_date) values(?,?,?)";
	//private static String UPDATE_QUERY ="update employeeportal.project set description =?, start_date =?, end_date=? where id=?";
	//private static String DELETE_QUERY = "delete from employeeportal.project where id= ?";
	//private static String SELECT_BY_ID_QUERY = "select * from employeeportal.project where id=?";

	@Override
	public List<Project> getAll() {
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        Root<Project> projectRoot = criteria.from(Project.class);
        criteria.select(projectRoot);
		
        List<Project> projects = session.createQuery(criteria).getResultList();
		
		session.close();
   
		return projects;
	}

	@Override
	public boolean insert(Project project) {
	
		Session session = sessionFactory.openSession();
	
		
		try{
		
			session.save(project);
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
        return true;
	}

	@Override
	public boolean update(Project project) {
	
		
		Session session = sessionFactory.openSession();
	
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaUpdate<Project> criteria = builder.createCriteriaUpdate(Project.class);
        Root<Project> projectRoot = criteria.from(Project.class);
        criteria.set(projectRoot.get("description"), project.getDescription()).where(builder.equal(projectRoot.get("id"), project.getId()));
        criteria.set(projectRoot.get("startDate"), project.getStartDate()).where(builder.equal(projectRoot.get("id"), project.getId()));
        criteria.set(projectRoot.get("endDate"), project.getEndDate()).where(builder.equal(projectRoot.get("id"), project.getId()));
 	
        int updatedRows = session.createQuery(criteria).executeUpdate();
        
        session.close();
        
		return updatedRows>0;
        
	}

	@Override
	public boolean delete(Project project) {
		
		
		Session session = sessionFactory.openSession();
		
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaDelete<Project> criteria = builder.createCriteriaDelete(Project.class);
        Root<Project> projectRoot = criteria.from(Project.class);
        criteria.where(builder.equal(projectRoot.get("id"), project.getId()));
        
        int deletedRows = session.createQuery(criteria).executeUpdate();
        
        session.close();
       
        return deletedRows>0;
	}

	@Override
	public Project getProjectByID(int id) {
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        Root<Project> projectRoot = criteria.from(Project.class);
        criteria.select(projectRoot);
        criteria.where(builder.equal(projectRoot.get("id"), id));
		
        Project project = session.createQuery(criteria).getSingleResult();
		
		session.close();
		
		return project;
		
	}

}
