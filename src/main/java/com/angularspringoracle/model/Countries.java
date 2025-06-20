package com.angularspringoracle.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Countries implements Serializable{
	
	private static final long serialVersionUID = 5443327967369616565L;

	@Id
	@Column(name="COUNTRY_ID")
	private String countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@ManyToOne
    @JoinColumn(name = "REGION_ID")
	private Region region;


	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Countries(String id, String countryName, Region region) {
		super();
		this.countryId = id;
		this.countryName = countryName;
		this.region = region;
	}
	
	public Countries(String id, String countryName) {
		super();
		this.countryId = id;
		this.countryName = countryName;
	}
	
	public Countries() {
		
	}

	@Override
	public String toString() {
		return "Countries [id=" + countryId + ", countryName=" + countryName + "]";
	}
	
}