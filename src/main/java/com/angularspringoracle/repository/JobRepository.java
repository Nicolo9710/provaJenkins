package com.angularspringoracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angularspringoracle.model.Job;

public interface JobRepository extends JpaRepository<Job, String> {
	List<Job> findAllByOrderByJobTitleAsc();
}
