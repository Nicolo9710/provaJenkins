package com.angularspringoracle.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.angularspringoracle.dto.EmployeeDto;
import com.angularspringoracle.model.Employee;
import com.angularspringoracle.model.Job;
import com.angularspringoracle.repository.JobRepository;
@Component
public class EmployeeMapper {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private JobRepository jobRepo;
	
	public EmployeeMapper(JobRepository jobRepo) {
		this.jobRepo = jobRepo;
	}
	
	public static EmployeeDto mapToDto(Employee employee) {
		if (employee == null) {
			return null;
		}
		EmployeeDto dto = new EmployeeDto();
		dto.setId(employee.getId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setEmail(employee.getEmail());
		dto.setPhoneNumber(employee.getPhoneNumber());

		if (employee.getHireDate() != null) {
			dto.setHireDate(sdf.format(employee.getHireDate()));
		}

		dto.setSalary(employee.getSalary());

		if (employee.getJob() != null) {
			dto.setJobTitle(employee.getJob().getJobTitle());
			dto.setJobId(employee.getJob().getJobId());
		}
		dto.setDepartment(employee.getDepartment());

		return dto;
	}

	public Employee mapToEmployee(EmployeeDto dto) {
		if (dto == null) {
			return null;
		}
		Employee newEmployee = new Employee();
		newEmployee.setId(dto.getId());
		newEmployee.setFirstName(dto.getFirstName());
		newEmployee.setLastName(dto.getLastName());
		newEmployee.setEmail(dto.getEmail());
		newEmployee.setPhoneNumber(dto.getPhoneNumber());
		newEmployee.setSalary(dto.getSalary());
		if (dto.getHireDate() != null) {
			try {
				newEmployee.setHireDate(sdf.parse(dto.getHireDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Job existingJob = jobRepo.findById(dto.getJobId()).orElseThrow(() -> new RuntimeException("Job non trovato"));
		newEmployee.setJob(existingJob);
		newEmployee.setDepartment(dto.getDepartment());
		return newEmployee;
	}
}