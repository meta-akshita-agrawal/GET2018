package com.metacube.advertismentWebServices.facade;

import java.util.List;

import com.metacube.advertismentWebServices.dao.*;
import com.metacube.advertismentWebServices.entity.Category;
import com.metacube.advertismentWebServices.enums.Status;

public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	CategoryDao categoryDao = MySQLCategoryDao.getInstance();

	//CREATES SINGLE INSTANCE
	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	/**
	 * Gets all categories
	 * @return list of categories
	 */
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	/**
	 * Creates a category
	 * @param category
	 * @return status
	 */
	public Status createCategory(Category category) {

		List<Category> categoryList = categoryDao.getAll();
		int result = categoryDao.insert(category);

		if (result == 1) {
			return Status.INSERTED;
		}

		//checks if there exist a category with same name
		for (Category tempCategory : categoryList) {
			if (tempCategory.getName().equals(category.getName())) {
				return Status.DUPLICATE;
			}
		}

		return Status.ERROR;
	}

	/**
	 * Gets a category using its id
	 * @param id
	 * @return category
	 */
	public Category getCategoryById(int id) {

		return categoryDao.getCategoryById(id);
	}

	/**
	 * Updates a category name
	 * @param name
	 * @param id
	 * @return status 
	 */
	public Status updateCategoryNameByCategoryId(String name, int id) {

		int result = categoryDao.updateNameById(name, id);

		if (result == 1) {
			return Status.UPDATED;
		}
		return Status.NOT_FOUND;
	}

}
