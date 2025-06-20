package com.angularspringoracle.dto;

import java.io.Serializable;

public class ParamListDto implements Serializable {

	private static final long serialVersionUID = 5546914607580737311L;
	
	private Integer departmentId;
	private String countryId;
	private Integer locationId;
	private Integer regionId;
	private String employeeName;
	private Integer minSalary;
	private Integer maxSalary;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public ParamListDto(Integer departmentId, String countryId, Integer locationId, Integer regionId,
			String employeeName, Integer minSalary, Integer maxSalary) {
		super();
		this.departmentId = departmentId;
		this.countryId = countryId;
		this.locationId = locationId;
		this.regionId = regionId;
		this.employeeName = employeeName;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public ParamListDto() {

	}
}
