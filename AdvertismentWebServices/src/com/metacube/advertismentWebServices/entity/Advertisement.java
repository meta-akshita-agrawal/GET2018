package com.metacube.advertismentWebServices.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Advertisement {

    @XmlElement(name="advertisementID")
	public int advertisementID;
    @XmlElement(name="title")
	public String title;
    @XmlElement(name="description")
	public String description;
    @XmlElement(name="categoryID")
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

	public Advertisement(int advertisementID, String title, String description,
			int categoryID) {
		this.advertisementID = advertisementID;
		this.title = title;
		this.description = description;
		this.categoryID = categoryID;
	}
	
}
