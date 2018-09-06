package com.metacube.training.model;

import java.util.Date;

public class Project {
	private int id;
	private String description;
	private Date start_date;
	private Date end_date;
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public Date getStart_date() {
		return start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	
}
