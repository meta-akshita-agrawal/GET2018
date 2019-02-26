package com.metacube.training.dao;

import java.util.List;

public interface BaseDao<T> {

	public List<T> getAll();
	public boolean insert(T entity);
	public boolean update(T entity);
	public boolean delete(T entity);
	
}
