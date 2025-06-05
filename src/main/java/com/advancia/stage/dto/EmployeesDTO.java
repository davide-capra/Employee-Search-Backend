package com.advancia.stage.dto;

import java.io.Serializable;

public class EmployeesDTO implements Serializable {

	private static final long serialVersionUID = -1751697539351396565L;

	private Integer idEmployee;
	private String nome;
	private String cognome;
	private Double salary;
	private String departmentName;
	private String locationName;
	private String regionName;
	private String countryName;

	// Costruttore vuoto
	public EmployeesDTO() {
		super();
	}

	public EmployeesDTO(Integer idEmployee, String nome, String cognome, Double salary, String departmentName,
			String locationName, String regionName, String countryName) {
		super();
		this.idEmployee = idEmployee;
		this.nome = nome;
		this.cognome = cognome;
		this.salary = salary;
		this.departmentName = departmentName;
		this.locationName = locationName;
		this.regionName = regionName;
		this.countryName = countryName;
	}

	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}