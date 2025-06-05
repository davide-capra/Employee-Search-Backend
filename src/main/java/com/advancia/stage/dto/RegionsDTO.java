package com.advancia.stage.dto;

import java.io.Serializable;

public class RegionsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer regionId;
	private String regionName;

	public RegionsDTO(Integer regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}

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
