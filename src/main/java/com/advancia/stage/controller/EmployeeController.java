package com.advancia.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advancia.stage.dto.EmployeeFilterDTO;
import com.advancia.stage.dto.EmployeesDTO;
import com.advancia.stage.model.Countries;
import com.advancia.stage.model.Departments;
import com.advancia.stage.model.Employees;
import com.advancia.stage.model.Locations;
import com.advancia.stage.model.Regions;
import com.advancia.stage.service.EmployeesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Tag(name = "HR API", description = "API per accesso a Employees, Departments, Locations, ecc.")
public class EmployeeController {

	@Autowired
	private EmployeesService empService;

	@Operation(summary = "Recupera tutti gli impiegati")
	@GetMapping("/employees")
	public List<Employees> getAllEmp() {
		return empService.findAllEmployees();
	}

	@Operation(summary = "Recupera tutti i dipartimenti")
	@GetMapping("/departments")
	public List<Departments> getAllDeps() {
		return empService.findAllDepartments();
	}

	@Operation(summary = "Recupera tutte le sedi (locations)")
	@GetMapping("/locations")
	public List<Locations> getAllLocs() {
		return empService.findAllLocations();
	}

	@GetMapping("/countries")
	public List<Countries> getAllCountry() {
		return empService.findAllCountries();
	}

	@GetMapping("/regions")
	public List<Regions> getAllRegs() {
		return empService.findAllRegions();
	}

	@PostMapping("/filter")
	public ResponseEntity<List<EmployeesDTO>> getFilteredEmployees(@RequestBody EmployeeFilterDTO filters) {
		List<EmployeesDTO> results = empService.getAllEmployeesByFilters(filters);
		return ResponseEntity.ok(results);
	}
	@Operation(summary ="Cancella un impiegato tramite il suo id")
	@DeleteMapping("employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		boolean deleted = empService.eliminaEmployeesById(id);

		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary ="Restituisce un impiegato tramite il suo id")
	@GetMapping("employees/{id}")
	public ResponseEntity<EmployeesDTO> getEmployeeById(@PathVariable int id) {
		EmployeesDTO empDTO = empService.getEmployeesDTOById(id);
		if (empDTO != null) {
			return ResponseEntity.ok(empDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
