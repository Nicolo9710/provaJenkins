package com.angularspringoracle.dto;

import java.io.Serializable;

public class CountryDto implements Serializable {

	private static final long serialVersionUID = -4948664182004674769L;

	private String countryId;
	private String countryName;
	private Long regionId;

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long long1) {
		this.regionId = long1;
	}

	public CountryDto(String countryId, String countryName, Long regionId) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.regionId = regionId;
	}

	public CountryDto() {

	}
}
