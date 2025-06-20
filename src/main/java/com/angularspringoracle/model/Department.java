package com.angularspringoracle.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

	private static final long serialVersionUID = 1033621016307135797L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@Column(name = "MANAGER_ID")
	private Integer managerId;

	@ManyToOne
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Department(Long departmentId, String departmentName, Integer managerId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
	}
	
	public Department(Long departmentId, String departmentName, Integer managerId, Location location) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.location = location;
	}
	
	public Department() {

	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + "]";
	}

}
