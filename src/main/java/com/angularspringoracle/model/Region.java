package com.angularspringoracle.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region implements Serializable {

	private static final long serialVersionUID = -1225703624502327489L;

	@Id
	@Column(name = "REGION_ID")
	private Long regionId;

	@Column(name = "REGION_NAME")
	private String regionName;

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Region(Long regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public Region() {

	}
}
