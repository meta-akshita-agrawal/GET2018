package com.metacube.advertismentWebServices.entity;

//POJO for advertisement
public class Advertisement {

	public int advertisementID;
	public String title;
	public String description;
	public int categoryID;

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

	public void setAdvertisementID(int advertisementID) {
		this.advertisementID = advertisementID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

}
