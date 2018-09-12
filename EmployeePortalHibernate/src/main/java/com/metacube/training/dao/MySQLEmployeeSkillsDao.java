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

import com.metacube.training.model.EmployeeSkills;

@Repository
@Transactional
public class MySQLEmployeeSkillsDao implements EmployeeSkillsDao{
	
	
	//private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public MySQLEmployeeSkillsDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//private static final String SELECT_QUERY="select * from employeeportal.employee_skills";
	//private static final String INSERT_QUERY="insert into employeeportal.employee_skills(employee_code,skill_name) values(?,?) ";
	//private static final String GET_SKILL_BY_EMPLOYEE_ID_QUERY = "select * from employeeportal.employee_skills where employee_code=?";
	
	@Override
	public List<EmployeeSkills> getAll() {
		//return jdbcTemplate.query(SELECT_QUERY, new EmployeeSkillsMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<EmployeeSkills> criteria = builder.createQuery(EmployeeSkills.class);
        Root<EmployeeSkills> employeeSkillsRoot = criteria.from(EmployeeSkills.class);
        criteria.select(employeeSkillsRoot);
		
        List<EmployeeSkills> employeeSkills = session.createQuery(criteria).getResultList();
		
		session.close();
   
		return employeeSkills;
	}

	@Override
	public boolean insert(EmployeeSkills entity) {
		//return jdbcTemplate.update(INSERT_QUERY, entity.getEmployeeID(), entity.getSkillName()) > 0;
		Session session = sessionFactory.openSession();
		
		try{
			
			session.save(entity);
			
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
        return true;
		
	}

	@Override
	public boolean update(EmployeeSkills entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EmployeeSkills entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeSkills> getSkillsByEmployeeId(int id) {
		//return jdbcTemplate.query(GET_SKILL_BY_EMPLOYEE_ID_QUERY, new Object[]{id}, new EmployeeSkillsMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<EmployeeSkills> criteria = builder.createQuery(EmployeeSkills.class);
        Root<EmployeeSkills> employeeSkillsRoot = criteria.from(EmployeeSkills.class);
        criteria.select(employeeSkillsRoot);
        criteria.where(builder.equal(employeeSkillsRoot.get("id"), id));
		
        List<EmployeeSkills> employeeSkills = session.createQuery(criteria).getResultList();
		
		session.close();
		
		return employeeSkills;
	}

	@Override
	public boolean insertSkillsForEmployeeID(String[] skills, int id) {
		for(String skill:skills){
			EmployeeSkills empSkills = new EmployeeSkills();
			empSkills.setEmployeeID(id);
			empSkills.setSkillName(skill);
			boolean check = insert(empSkills);
			if(!check){
				return false;
			}
		}

		return true;
	}

}
