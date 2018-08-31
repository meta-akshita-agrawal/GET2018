package com.metacube.user.dao;

import java.util.List;

@SuppressWarnings("hiding")
public interface BaseDao<Object>{

	public List<Object> getAll();
	public int insert(Object entity);
	public int update(Object entity);
	public int delete(Object entity);

	
}
