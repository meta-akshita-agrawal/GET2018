package com.metacube.user.pojo;

//POJO for user
public class User {
	
	String firstName;
	String lastName;
	String password;
	String email;
	String contactNumber;
	String companyName;
	
	
	public User(String firstName,String lastName,String password,String email,String contactNumber,String companyName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.companyName = companyName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail(){
		return email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	
}
