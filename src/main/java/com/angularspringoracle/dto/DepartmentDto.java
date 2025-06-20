package com.angularspringoracle.dto;

import java.io.Serializable;

public class DepartmentDto implements Serializable {

	private static final long serialVersionUID = 8353546731252002759L;

	private Long departmentId;
	private String departmentName;
	private Integer managerId;
	private Long locationId;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public DepartmentDto(Long departmentId, String departmentName, Integer managerId, Long locationId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public DepartmentDto() {

	}
}
