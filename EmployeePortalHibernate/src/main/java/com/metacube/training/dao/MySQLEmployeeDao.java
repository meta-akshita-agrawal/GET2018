package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public class MySQLEmployeeDao implements EmployeeDao{

	//private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public MySQLEmployeeDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*private static final String SELECT_QUERY= "select * from employeeportal.employee";
	private static final String INSERT_QUERY= "insert into employeeportal.employee(first_name,last_name,dob,gender,contact_no,email_id) values (?,?,?,?,?,?)";
	private static final String UPDATE_QUERY = "update employeeportal.employee set first_name=?, last_name=?, dob=?, gender=?, contact_no=?,email_id=? where id=?";
	private static final String DELETE_QUERY = "delete from employeeportal.employee where id=?";
	private static final String SELECT_BY_ID_QUERY = "select *  from employeeportal.employee where id = ?";
	private static final String SELECT_BY_NAME_QUERY = "select * from employeeportal.employee where first_name=?";
	private static final String GET_ID_BY_EMAIL = "select * from employeeportal.employee where email_id=?";
	*/
	@Override
	public List<Employee> getAll() {
		//return jdbcTemplate.query(SELECT_QUERY, new EmployeeMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
		
        List<Employee> employee = session.createQuery(criteria).getResultList();
		
		session.close();
   
		return employee;
	}

	@Override
	public boolean insert(Employee employee) {
		//return jdbcTemplate.update(INSERT_QUERY,employee.getFirstName(), employee.getLastName(), employee.getDob(),employee.getGender(), employee.getContactNumber(), employee.getEmailID()) > 0;	
		
		Session session = sessionFactory.openSession();
		
		
		try{
			
			session.save(employee);
			
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
        return true;
	}

	@Override
	public boolean update(Employee employee) {
		//return jdbcTemplate.update(UPDATE_QUERY, employee.getFirstName(), employee.getLastName(), employee.getDob(), employee.getGender(), employee.getContactNumber() ,employee.getEmployeeID()) > 0;

		Session session = sessionFactory.openSession();
		
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaUpdate<Employee> criteria = builder.createCriteriaUpdate(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.set(employeeRoot.get("firstName"), employee.getFirstName()).where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        criteria.set(employeeRoot.get("lastName"), employee.getLastName()).where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        criteria.set(employeeRoot.get("dob"), employee.getDob()).where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        criteria.set(employeeRoot.get("gender"), employee.getGender()).where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        criteria.set(employeeRoot.get("contactNumber"), employee.getContactNumber()).where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        criteria.set(employeeRoot.get("emailID"), employee.getEmailID()).where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        
        int updatedRows = session.createQuery(criteria).executeUpdate();
        session.close();
		
        return updatedRows>0;
	}

	@Override
	public boolean delete(Employee employee) {
		//return jdbcTemplate.update(DELETE_QUERY, employee.getEmployeeID()) > 0;
		
		Session session = sessionFactory.openSession();

		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaDelete<Employee> criteria = builder.createCriteriaDelete(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.where(builder.equal(employeeRoot.get("employeeID"), employee.getEmployeeID()));
        
        int deletedRows = session.createQuery(criteria).executeUpdate();
        
        session.close();
        
        return deletedRows>0;
		
	}

	@Override
	public Employee getEmployeeByID(int id) {
		//return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[]{id}, new EmployeeMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("employeeID"), id));
		
        Employee employee = session.createQuery(criteria).getSingleResult();
		
		session.close();
		
		return employee;
		
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		//return jdbcTemplate.query(SELECT_BY_NAME_QUERY, new Object[] {name}, new EmployeeMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("firstName"), name));
		
        List<Employee> employee = session.createQuery(criteria).getResultList();
		
		session.close();
		
		return employee;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		//return jdbcTemplate.queryForObject(GET_ID_BY_EMAIL, new Object[] {email}, new EmployeeMapper());
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("emailID"), email));
		
        Employee employee = (Employee)session.createQuery(criteria).getSingleResult();
		
		session.close();
		
		return employee;
		
	}

	
}
