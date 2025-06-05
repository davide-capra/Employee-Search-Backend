package com.advancia.stage.dto;

import java.io.Serializable;

public class CountriesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String countryId;
	private String countryName;

	public CountriesDTO() {
		super();
	}

	public CountriesDTO(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

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

}
