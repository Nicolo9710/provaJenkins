package com.angularspringoracle.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class Location implements Serializable {

	private static final long serialVersionUID = 6133007338655878124L;

	@Id
	@Column(name = "LOCATION_ID")
	private Long locationId;

	@Column(name = "STREET_ADDRESS")
	private String streetAddress;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE_PROVINCE")
	private String stateProvince;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Countries country;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	public Location(Long locationId, String streetAddress, String postalCode, String city, String stateProvince,
			Countries country) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	public Location() {

	}
}
