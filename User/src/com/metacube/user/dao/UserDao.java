package com.metacube.user.dao;

import java.util.List;

import com.metacube.user.pojo.User;

//Extending basic DAO interface
public interface UserDao extends BaseDao<User> {

	public User getUserByEmail(String email);//getting all details of a user by email
	public List<String> getEmailListByCompanyName(String companyName,String email);//getting all users in the company
}
