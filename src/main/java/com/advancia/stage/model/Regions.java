package com.advancia.stage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
public class Regions {

	@Id
	@Column(name = "region_id", nullable = false)
	private Integer regionId;

	@Column(name = "region_name", nullable = false)
	private String regionName;

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}
