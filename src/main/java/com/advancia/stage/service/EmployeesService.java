package com.advancia.stage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advancia.stage.controller.EmployeeController;
import com.advancia.stage.dto.EmployeeFilterDTO;
import com.advancia.stage.dto.EmployeeUpdateDTO;
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

	public void updateEmployee(EmployeeUpdateDTO employeeUpdate) {
	    // 1. Recupero dell'impiegato
	    Employees employee = employeesRepository.findById(employeeUpdate.getIdEmployee())
	            .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

	    // 2. Aggiornamento dei campi base
	    employee.setFirstName(employeeUpdate.getNome());
	    employee.setLastName(employeeUpdate.getCognome());
	    employee.setSalary(employeeUpdate.getSalary());

	    // 3. Aggiornamento del dipartimento (obbligatorio se cambia)
	    if (employeeUpdate.getDepartmentId() != null) {
	        Departments dept = departmentRepository.findById(employeeUpdate.getDepartmentId())
	                .orElseThrow(() -> new EntityNotFoundException("Dipartimento non trovato"));
	        employee.setDepartment(dept);
	    }

	    // 4. Aggiornamento della Location (se richiesto)
	    if (employeeUpdate.getLocationId() != null) {
	        Locations location = locationRepository.findById(employeeUpdate.getLocationId())
	                .orElseThrow(() -> new EntityNotFoundException("Location non trovata"));
	        Departments dept = employee.getDepartment();
	        dept.setLocation(location);
	        departmentRepository.save(dept);
	    }

	    // 5. Aggiornamento del Country (se richiesto)
	    if (employeeUpdate.getCountryId() != null) {
	        Countries country = countryRepository.findById(employeeUpdate.getCountryId())
	                .orElseThrow(() -> new EntityNotFoundException("Country non trovata"));
	        Locations location = employee.getDepartment().getLocation();
	        location.setCountry(country);
	        locationRepository.save(location);
	    }

	    // 6. Aggiornamento della Region (se richiesto)
	    if (employeeUpdate.getRegionId() != null) {
	        Regions region = regionRepository.findById(employeeUpdate.getRegionId())
	                .orElseThrow(() -> new EntityNotFoundException("Region non trovata"));
	        Countries country = employee.getDepartment().getLocation().getCountry();
	        country.setRegion(region);
	        countryRepository.save(country);
	    }

	    // 7. Salvataggio dell’impiegato aggiornato
	    employeesRepository.save(employee);
	}


//	public EmployeesDTO updateEmployee(int id, EmployeesDTO employeedto) {
//		Employees updateEmp=employeesRepitory.findById(id)
//				.orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
//		updateEmp.setFirstName(employeedto.getNome());
//		updateEmp.setLastName(employeedto.getCognome());
//		updateEmp.setSalary(employeedto.getSalary());
//		updateEmp.setDepartment(employeedto.getDepartmentName());
//		
//		
//	}

}
