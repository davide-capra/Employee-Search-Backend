package com.advancia.stage.dto;

import java.io.Serializable;

public class DepartmentsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer departmentsId;
	private String departmentsName;

	public DepartmentsDTO() {

	}

	public DepartmentsDTO(Integer departmentsId, String departmentsName) {
		super();
		this.departmentsId = departmentsId;
		this.departmentsName = departmentsName;
	}

	public Integer getDepartmentsId() {
		return departmentsId;
	}

	public void setDepartmentsId(Integer departmentsId) {
		this.departmentsId = departmentsId;
	}

	public String getDepartmentsName() {
		return departmentsName;
	}

	public void setDepartmentsName(String departmentsName) {
		this.departmentsName = departmentsName;
	}

}
