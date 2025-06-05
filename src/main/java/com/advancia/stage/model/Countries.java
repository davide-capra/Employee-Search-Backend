package com.advancia.stage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
public class Countries {
	@Id
	@Column(name = "country_id", nullable = false)
	private String countryId;

	@Column(name = "country_name", nullable = false)
	private String countryName;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Regions region;

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

	public Regions getRegion() {
		return region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

}
