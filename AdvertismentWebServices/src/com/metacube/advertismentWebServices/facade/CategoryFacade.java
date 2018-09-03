package com.metacube.advertismentWebServices.facade;

import java.util.List;

import com.metacube.advertismentWebServices.dao.*;
import com.metacube.advertismentWebServices.entity.Category;
import com.metacube.advertismentWebServices.enums.Status;

public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	CategoryDao categoryDao = MySQLCategoryDao.getInstance();

	public static CategoryFacade getInstance() {
		return categoryFacade;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	/**
	 * 
	 * @param category
	 * @return
	 */
	public Status createCategory(Category category) {

		List<Category> categoryList = categoryDao.getAll();
		int result = categoryDao.insert(category);

		if (result == 1) {
			return Status.INSERTED;
		}

		for (Category tempCategory : categoryList) {
			if (tempCategory.getName().equals(category.getName())) {
				return Status.DUPLICATE;
			}
		}

		return Status.ERROR;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Category getCategoryById(int id) {

		return categoryDao.getCategoryById(id);
	}

	/**
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public Status updateCategoryNameByCategoryId(String name, int id) {

		int result = categoryDao.updateNameById(name, id);

		if (result == 1) {
			return Status.UPDATED;
		}
		return Status.NOT_FOUND;
	}

}
