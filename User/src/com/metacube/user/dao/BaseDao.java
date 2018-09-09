package com.metacube.user.dao;

import java.util.List;

//INTERFACE FOR BASIC DAO METHODS
public interface BaseDao<T>{

	public List<T> getAll();//getting all users
	public int insert(T entity);//inserting a new user
	public int update(T entity);//updating details of a user
	public int delete(T entity);//deleting user

	
}
