package com.advancia.stage.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.advancia.stage.dto.EmployeeFilterDTO;
import com.advancia.stage.dto.EmployeesDTO;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<EmployeesDTO> getAllEmployeesByFilters(EmployeeFilterDTO dto) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT new com.advancia.stage.dto.EmployeesDTO(");

		str.append(
				"e.employeeId, e.firstName, e.lastName, e.salary, e.department.departmentName, e.department.location.streetAddress, e.department.location.country.region.regionName, e.department.location.country.countryName) ");
		str.append("FROM Employees e ");
		str.append("WHERE e.dataFine IS NULL ");

		Map<String, Object> params = new HashMap<>();

		if (dto.getNome() != null && !dto.getNome().isEmpty()) {
			str.append("AND LOWER(e.firstName) LIKE LOWER(:nome) ");
			params.put("nome", "%" + dto.getNome() + "%");
		}

		if (dto.getCognome() != null && !dto.getCognome().isEmpty()) {
			str.append("AND LOWER(e.lastName) LIKE LOWER(:cognome) ");
			params.put("cognome", "%" + dto.getCognome() + "%");
		}

		if (dto.getIdDepartment() != null) {
			str.append("AND e.department.departmentId = :idDepartment ");
			params.put("idDepartment", dto.getIdDepartment());
		}

		if (dto.getIdLocation() != null) {
			str.append("AND e.department.location.locationId = :idLocation ");
			params.put("idLocation", dto.getIdLocation());
		}

		if (dto.getIdRegion() != null) {
			str.append("AND e.department.location.country.region.regionId = :idRegion ");
			params.put("idRegion", dto.getIdRegion());
		}

		if (dto.getIdCountry() != null) {
			str.append("AND e.department.location.country.countryId = :idCountry ");
			params.put("idCountry", dto.getIdCountry());
		}

		if (dto.getMinSalary() != null) {
			str.append("AND e.salary >= :minSalary ");
			params.put("minSalary", dto.getMinSalary());
		}

		if (dto.getMaxSalary() != null) {
			str.append("AND e.salary <= :maxSalary ");
			params.put("maxSalary", dto.getMaxSalary());
		}

		TypedQuery<EmployeesDTO> query = em.createQuery(str.toString(), EmployeesDTO.class);
		params.forEach(query::setParameter);

		return query.getResultList();
	}

}
