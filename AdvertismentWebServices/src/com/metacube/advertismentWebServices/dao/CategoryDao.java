package com.metacube.advertismentWebServices.dao;

import com.metacube.advertismentWebServices.entity.Category;

public interface CategoryDao extends BaseDao<Category> {

	public Category getCategoryById(int id);
}
