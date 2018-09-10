package com.metacube.training.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Project {
	private int id;
	private String description;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date endDate;
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	
}
