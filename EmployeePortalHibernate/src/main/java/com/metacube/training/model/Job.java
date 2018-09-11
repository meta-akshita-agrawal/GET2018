package com.metacube.training.model;

import javax.persistence.*;

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@Column(name="job_code")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobCode;
	
	@Column(name="title")
	private String title;
	
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getJobCode() {
		return jobCode;
	}
	public String getTitle() {
		return title;
	}
}
