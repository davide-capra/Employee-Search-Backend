package com.advancia.stage.repository;

import java.util.List;

import com.advancia.stage.dto.EmployeeFilterDTO;
import com.advancia.stage.dto.EmployeesDTO;

public interface EmployeeRepositoryCustom {
	List<EmployeesDTO> getAllEmployeesByFilters(EmployeeFilterDTO dto);
	
}
