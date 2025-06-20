package com.angularspringoracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angularspringoracle.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findAllByOrderByDepartmentNameAsc();
}
