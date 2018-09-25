package com.metacube.training.model;

import java.util.Date;


import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="contact_no")
	private String contactNumber;
	
	@Column(name="email_id")
	private String emailID;
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="employee", cascade=CascadeType.ALL)
//	private List<EmployeeSkills> employeeSkills;
	
//	public List<EmployeeSkills> getEmployeeSkills() {
//		return employeeSkills;
//	}
//	public void setEmployeeSkills(List<EmployeeSkills> employeeSkills) {
//		this.employeeSkills = employeeSkills;
//	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDob() {
		return dob;
	}
	public String getGender() {
		return gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getEmailID() {
		return emailID;
	}
}
