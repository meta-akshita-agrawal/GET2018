package com.metacube.advertismentWebServices.entity;

public class Category {

	private int categoryID;
	private String name;
	
	
	public int getCategoryID() {
		return categoryID;
	}
	
	public String getName() {
		return name;
	}

	public Category(int categoryID, String name) {
		this.categoryID = categoryID;
		this.name = name;
	}

	
}
