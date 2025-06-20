package com.angularspringoracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angularspringoracle.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	List<Location> findAllByOrderByCityAsc();

}
