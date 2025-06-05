package com.advancia.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advancia.stage.model.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {

}
