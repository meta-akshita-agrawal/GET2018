package com.metacube.training.model;

import java.util.Date;

public class Employee {

	private int employeeID;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String contactNumber;
	private String emailID;
	

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
