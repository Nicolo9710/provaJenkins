package com.angularspringoracle.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Job implements Serializable {

	private static final long serialVersionUID = 2298451122582789386L;

	@Id
	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "MIN_SALARY")
	private Integer minSalary;

	@Column(name = "MAX_SALARY")
	private Integer maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Job(String jobId, String jobTitle, Integer minSalary, Integer maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public Job() {

	}

	public Job(String jobId2, String jobTitle2) {
		super();
		this.jobId = jobId2;
		this.jobTitle = jobTitle2;
	}
}
