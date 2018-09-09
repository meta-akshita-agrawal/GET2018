package com.metacube.advertismentWebServices.dao;

import java.util.List;

//Interface for DAO
public interface BaseDao<T>{

	public List<T> getAll();//getting all data from data object
	public int insert(T entity);//insert entity in data
	public int updateNameById(String name,int id);//update name by id
	
}
