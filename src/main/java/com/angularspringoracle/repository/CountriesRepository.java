package com.angularspringoracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angularspringoracle.model.Countries;

public interface CountriesRepository extends JpaRepository<Countries, String> {
    List<Countries> findAllByOrderByCountryNameAsc();
}

