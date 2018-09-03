package com.metacube.advertismentWebServices.dao;

import java.util.List;

@SuppressWarnings("hiding")
public interface BaseDao<Object>{

	public List<Object> getAll();
	public int insert(Object entity);
	public int updateNameById(String name,int id);
	
}
