package com.angularspringoracle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angularspringoracle.model.Countries;
import com.angularspringoracle.model.Department;
import com.angularspringoracle.model.Employee;
import com.angularspringoracle.model.Job;
import com.angularspringoracle.model.Location;
import com.angularspringoracle.model.Region;
import com.angularspringoracle.repository.CountriesRepository;
import com.angularspringoracle.repository.DepartmentRepository;
import com.angularspringoracle.repository.EmployeeRepository;
import com.angularspringoracle.repository.JobRepository;
import com.angularspringoracle.repository.LocationRepository;
import com.angularspringoracle.repository.RegionsRepository;

@Service
@Transactional
public class EmployeeService {

	private EmployeeRepository employeeRepo;
	private DepartmentRepository departmentRepo;
	private CountriesRepository countriesRepo;
	private LocationRepository locationRepo;
	private RegionsRepository regionRepo;
	private JobRepository jobRepo;
	
	public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo, CountriesRepository countriesRepo,
		LocationRepository locationRepo, RegionsRepository regionRepo, JobRepository jobRepo) {
		
		this.employeeRepo = employeeRepo;
		this.departmentRepo = departmentRepo;
		this.countriesRepo = countriesRepo;
		this.locationRepo = locationRepo;
		this.regionRepo = regionRepo;
		this.jobRepo = jobRepo;
	}
	
	@Cacheable(value = "employee")
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}
	
	public List<Employee> findAll(Specification<Employee> filterByParams) {
		return employeeRepo.findAll(filterByParams);
	}

	public Employee save(Employee newEmployee) {
		return employeeRepo.save(newEmployee);
	}

	public List<Department> findAllByOrderByDepartmentNameAsc() {
		return departmentRepo.findAllByOrderByDepartmentNameAsc();
	}

	public List<Location> findAllByOrderByCityAsc() {
		return locationRepo.findAllByOrderByCityAsc();
	}

	public List<Countries> findAllByOrderByCountryNameAsc() {
		return countriesRepo.findAllByOrderByCountryNameAsc();
	}

	public List<Region> findAllByOrderByRegionNameAsc() {
		return regionRepo.findAllByOrderByRegionNameAsc();
	}

	public List<Job> findAllByOrderByJobTitleAsc() {
		return jobRepo.findAllByOrderByJobTitleAsc();
	}
	
	@Cacheable(value = "employee", key = "#id")
	public Optional<Employee> findEmployeeById(long id) {
		return employeeRepo.findById(id);
	}

	public Optional<Job> findJobById(String id) {
		return jobRepo.findById(id);
	}

	public void deleteById(long id) {
		employeeRepo.deleteById(id);
	}

}
