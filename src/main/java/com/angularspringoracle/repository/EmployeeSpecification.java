package com.angularspringoracle.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.angularspringoracle.dto.ParamListDto;
import com.angularspringoracle.model.Employee;

import jakarta.persistence.criteria.Predicate;

public class EmployeeSpecification {
	
	private EmployeeSpecification() {
		throw new IllegalStateException("Utility class");
	}
	
    public static Specification<Employee> filterByParams(ParamListDto param) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (param.getDepartmentId() != null) {
                predicates.add(cb.equal(root.join("department").get("departmentId"), param.getDepartmentId()));
            }

            if (param.getCountryId() != null && !param.getCountryId().isEmpty()) {
                predicates.add(cb.equal(root.join("department")
                							.join("location")
                							.join("country")
                							.get("countryId"), param.getCountryId()));
            }
            
            if(param.getLocationId() != null) {
            	predicates.add(cb.equal(root.join("department")
            								.join("location")
            								.get("locationId"), param.getLocationId()
            			));
            }
            
            if(param.getRegionId() != null) {
            	predicates.add(cb.equal(root.join("department")
            								.join("location")
            								.join("country")
            								.join("region")
            								.get("regionId"), param.getRegionId()));
            }
            
            if(param.getEmployeeName() != null && !param.getEmployeeName().isEmpty()) {
            	predicates.add(cb.like(cb.lower(root.get("firstName")), 
            			"%" + param.getEmployeeName().toLowerCase() + "%"));
            	}
            if(param.getMinSalary()!= null) {
            	predicates.add(cb.ge(root.join("job").get("minSalary"), param.getMinSalary()));
            }
            if(param.getMaxSalary()!= null) {
            	predicates.add(cb.le(root.join("job").get("maxSalary"), param.getMaxSalary()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

