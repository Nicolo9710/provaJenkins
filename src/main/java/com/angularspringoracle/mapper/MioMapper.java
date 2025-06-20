package com.angularspringoracle.mapper;

import com.angularspringoracle.dto.CountryDto;
import com.angularspringoracle.dto.DepartmentDto;
import com.angularspringoracle.dto.JobDto;
import com.angularspringoracle.dto.LocationDto;
import com.angularspringoracle.model.Countries;
import com.angularspringoracle.model.Department;
import com.angularspringoracle.model.Job;
import com.angularspringoracle.model.Location;

public class MioMapper {
	
	  private MioMapper() {
		    throw new IllegalStateException("Utility class");
		  }
	  
	public static LocationDto mapLocationToDto(Location location) {
		if (location == null) {
			return null;
		}
		LocationDto dto = new LocationDto();
		
		dto.setCity(location.getCity());
		dto.setCountryId(location.getCountry().getCountryId());
		dto.setLocationId(location.getLocationId());
		dto.setPostalCode(location.getPostalCode());
		dto.setStateProvince(location.getStateProvince());
		dto.setStreetAddress(location.getStreetAddress());
		
		return dto;

	}
	
	public static CountryDto mapCountryToDto(Countries country) {
        if (country == null) return null;

        CountryDto dto = new CountryDto();
        dto.setCountryId(country.getCountryId());
        dto.setCountryName(country.getCountryName());
        dto.setRegionId(country.getRegion().getRegionId());
        return dto;
	}
	
	public static DepartmentDto mapDepartmentToDto(Department department) {
			
			if(department == null) {
				return null;
			}
			
			DepartmentDto dto = new DepartmentDto();
			dto.setDepartmentId(department.getDepartmentId());
			dto.setDepartmentName(department.getDepartmentName());
			dto.setManagerId(department.getManagerId());
			dto.setLocationId(department.getLocation().getLocationId());
			
			return dto;
		}
	
	public static JobDto mapJobToDto (Job job) {
		if(job == null ) {
			return null;
		}
		JobDto dto = new JobDto();
		dto.setJobId(job.getJobId());
		dto.setJobTitle(job.getJobTitle());
		dto.setMaxSalary(job.getMaxSalary());
		dto.setMinSalary(job.getMinSalary());
		
		return dto;
	}
	
}
