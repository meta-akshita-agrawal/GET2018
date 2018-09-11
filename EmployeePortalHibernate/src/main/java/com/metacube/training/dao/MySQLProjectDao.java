package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;











import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class MySQLProjectDao implements ProjectDao{

	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public MySQLProjectDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//private static String SELECT_ALL_QUERY = "select * from employeeportal.project";
	//private static String INSERT_QUERY = "insert into employeeportal.project(description,start_date,end_date) values(?,?,?)";
	private static String UPDATE_QUERY ="update employeeportal.project set description =?, start_date =?, end_date=? where id=?";
	private static String DELETE_QUERY = "delete from employeeportal.project where id= ?";
	private static String SELECT_BY_ID_QUERY = "select * from employeeportal.project where id=?";

	@Override
	public List<Project> getAll() {
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        Root<Project> projectRoot = criteria.from(Project.class);
        criteria.select(projectRoot);
		
        List<Project> projects = session.createQuery(criteria).getResultList();
		
		session.close();
        /*
		Criteria cr = session.createCriteria(Project.class);
		List projectList = cr.list();
		System.out.println(projectList.size());*/
		return projects;
	}

	@Override
	public boolean insert(Project project) {
	
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.save(project);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
        return true;
	}

	@Override
	public boolean update(Project project) {
		//return jdbcTemplate.update(UPDATE_QUERY, project.getDescription(),project.getStartDate(),project.getEndDate(),project.getId())>0;
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Query hql = session.createQuery("update Project set description=:description,start_date=:startDate,end_date=:endDate where id=:id");
		
		hql.setParameter("description", project.getDescription());
		hql.setParameter("startDate", project.getStartDate());
		hql.setParameter("endDate", project.getEndDate());
		hql.setParameter("id", project.getId());
		try{
			tx = session.beginTransaction();
			hql.executeUpdate();
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Project project) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Query hql = session.createQuery("delete from Project where id=:id");
		
		hql.setParameter("id", project.getId());
		try{
			tx = session.beginTransaction();
			hql.executeUpdate();
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Project getProjectByID(int id) {
		//return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[]{id}, new ProjectMapper());
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Project.class);
		Object project  = criteria.add(Restrictions.eq("id", id)).uniqueResult();
		//CriteriaBuilder builder = session.getCriteriaBuilder();
		
		//CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        //Root<Project> projectRoot = criteria.from(Project.class);
        //criteria.select(projectRoot);
       // Object project = criteria.getRestriction().
		
		session.close();
		
		return (Project) project;
		
	}

}
