package com.metacube.training.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {
	
	
	private int id;
	
	@NotNull
	@Size(min=2,max=40)
	private String description;
	
	@NotNull
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date startDate;
	
	@NotNull
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
