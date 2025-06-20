package com.angularspringoracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angularspringoracle.model.Region;

public interface RegionsRepository extends JpaRepository<Region, Long> {
	List<Region> findAllByOrderByRegionNameAsc();
}
