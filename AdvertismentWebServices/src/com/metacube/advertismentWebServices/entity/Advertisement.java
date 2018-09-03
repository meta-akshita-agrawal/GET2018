package com.metacube.advertismentWebServices.entity;

public class Advertisement {

	private int advertisementID;
	private String title;
	private String description;
	private int categoryID;
	
	public int getAdvertismentID() {
		return advertisementID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getCategoryID() {
		return categoryID;
	}

	public Advertisement(int advertisementID, String title, String description,
			int categoryID) {
		this.advertisementID = advertisementID;
		this.title = title;
		this.description = description;
		this.categoryID = categoryID;
	}
	
}
