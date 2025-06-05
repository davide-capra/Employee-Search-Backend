package com.advancia.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.advancia.stage.dto.EmployeesDTO;
import com.advancia.stage.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>, EmployeeRepositoryCustom {
	@Query("select new com.advancia.stage.dto.EmployeesDTO(e.employeeId, e.firstName, e.lastName, "
			+ "e.salary, e.department.departmentName, e.department.location.streetAddress, "
			+ "e.department.location.country.region.regionName, e.department.location.country.countryName) "
			+ "from Employees e where e.employeeId = :id")
	EmployeesDTO getEmployeeDTOById(@Param("id") int id);

}