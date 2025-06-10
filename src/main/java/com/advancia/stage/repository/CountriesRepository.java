package com.advancia.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advancia.stage.model.Countries;

public interface CountriesRepository extends JpaRepository<Countries, Integer> {

}
