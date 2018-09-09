package com.metacube.advertismentWebServices.dao;

import com.metacube.advertismentWebServices.entity.Category;

//EXTENDING BASE DAO WITH ADDITIONAL METHODS
public interface CategoryDao extends BaseDao<Category> {

	public Category getCategoryById(int id);
}
