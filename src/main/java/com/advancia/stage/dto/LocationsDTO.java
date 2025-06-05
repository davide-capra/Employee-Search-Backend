package com.advancia.stage.dto;

import java.io.Serializable;

public class LocationsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer locationId;
	private String streetAddress;

	public LocationsDTO(Integer locationId, String streetAddress) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
