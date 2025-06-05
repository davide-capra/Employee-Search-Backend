package com.advancia.stage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancia.stage.dto.EmployeeFilterDTO;
import com.advancia.stage.dto.EmployeesDTO;
import com.advancia.stage.model.Countries;
import com.advancia.stage.model.Departments;
import com.advancia.stage.model.Employees;
import com.advancia.stage.model.Locations;
import com.advancia.stage.model.Regions;
import com.advancia.stage.repository.CountriesRepository;
import com.advancia.stage.repository.DepartmentsRepository;
import com.advancia.stage.repository.EmployeesRepository;
import com.advancia.stage.repository.LocationsRepository;
import com.advancia.stage.repository.RegionsRepository;

@Service
public class EmployeesService {

	@Autowired
	private EmployeesRepository employeesRepository;

	@Autowired
	private DepartmentsRepository departmentRepository;

	@Autowired
	private LocationsRepository locationRepository;

	@Autowired
	private RegionsRepository regionRepository;

	@Autowired
	private CountriesRepository countryRepository;

	public List<Employees> findAllEmployees() {
		return employeesRepository.findAll();
	}

	public List<Departments> findAllDepartments() {
		return departmentRepository.findAll();
	}

	public List<Locations> findAllLocations() {
		return locationRepository.findAll();
	}

	public List<Countries> findAllCountries() {
		return countryRepository.findAll();
	}

	public List<Regions> findAllRegions() {
		return regionRepository.findAll();
	}

	public List<EmployeesDTO> getAllEmployeesByFilters(EmployeeFilterDTO dto) {
		return employeesRepository.getAllEmployeesByFilters(dto);
	}

	@Transactional
	public boolean eliminaEmployeesById(int idEmployees) {
		Optional<Employees> optional = employeesRepository.findById(idEmployees);

		if (optional.isPresent()) {
			Employees emp = optional.get();
			emp.setDataFine(LocalDate.now());
			employeesRepository.save(emp);
			return true;
		} else {
			return false;
		}
	}

	public EmployeesDTO getEmployeesDTOById(int id) {
		return employeesRepository.getEmployeeDTOById(id);
	}

}
