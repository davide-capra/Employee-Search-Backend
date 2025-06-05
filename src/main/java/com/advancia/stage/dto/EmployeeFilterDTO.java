package com.advancia.stage.dto;

import java.io.Serializable;

public class EmployeeFilterDTO implements Serializable {

	private static final long serialVersionUID = 6916236027549042515L;

	private String nome;
	private String cognome;
	private Integer idDepartment;
	private Integer idRegion;
	private Integer idLocation;
	private Integer idCountry;
	private Double minSalary;
	private Double maxSalary;

	// Costruttore vuoto
	public EmployeeFilterDTO() {
		super();
	}

	public EmployeeFilterDTO(String nome, String cognome, Integer idDepartment, Integer idRegion, Integer idLocation,
			Integer idCountry, Double minSalary, Double maxSalary) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.idDepartment = idDepartment;
		this.idRegion = idRegion;
		this.idLocation = idLocation;
		this.idCountry = idCountry;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	// Getters e Setters
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

	public Integer getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Integer idDepartment) {
		this.idDepartment = idDepartment;
	}

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

}
