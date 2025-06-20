package com.angularspringoracle.dto;

import java.io.Serializable;

import com.angularspringoracle.model.Department;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 4894258429503175022L;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private String jobTitle;
	private Float salary;
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String string) {
		this.hireDate = string;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String string) {
		this.jobId = string;
	}

	public EmployeeDto(Long id, String firstName, String lastName, String email, String phoneNumber, String hireDate,
			String jobTitle, Float salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}

	public EmployeeDto() {

	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobTitle=" + jobTitle + ", salary="
				+ salary + "]";
	}

}
