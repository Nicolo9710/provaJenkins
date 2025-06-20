package com.angularspringoracle.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angularspringoracle.dto.CountryDto;
import com.angularspringoracle.dto.DepartmentDto;
import com.angularspringoracle.dto.EmployeeDto;
import com.angularspringoracle.dto.JobDto;
import com.angularspringoracle.dto.LocationDto;
import com.angularspringoracle.dto.ParamListDto;
import com.angularspringoracle.mapper.EmployeeMapper;
import com.angularspringoracle.mapper.MioMapper;
import com.angularspringoracle.model.Countries;
import com.angularspringoracle.model.Department;
import com.angularspringoracle.model.Employee;
import com.angularspringoracle.model.Job;
import com.angularspringoracle.model.Location;
import com.angularspringoracle.model.Region;
import com.angularspringoracle.repository.EmployeeSpecification;
import com.angularspringoracle.service.EmployeeService;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:4200")
public class EmployeeController {

	private EmployeeService eService;
	
	private EmployeeMapper employeeMapper;
	
	public EmployeeController(EmployeeService eService, EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
		this.eService = eService;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAll() {
		try {
			List<Employee> listaEmployees = eService.findAll();
			if (listaEmployees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			List<EmployeeDto> dtoList = listaEmployees.stream().map(EmployeeMapper::mapToDto)
					.toList();

			return new ResponseEntity<>(dtoList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getFilteredEmployees(@RequestBody ParamListDto param) {
		try {
			List<Employee> employeesFiltrati = eService.findAll(EmployeeSpecification.filterByParams(param));
			List<EmployeeDto> dtos = employeesFiltrati.stream().map(EmployeeMapper::mapToDto).toList();


			if (employeesFiltrati.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id){
		try {
			Optional<Employee> employeeTrovato = eService.findEmployeeById(id);
			if (employeeTrovato.isPresent()) {
	            
	            EmployeeDto dto = EmployeeMapper.mapToDto(employeeTrovato.get());
	            
	            return new ResponseEntity<>(dto, HttpStatus.OK);
			} else {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@PostMapping("/employees/add")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee) {
		
		try {
			Employee newEmployee = employeeMapper.mapToEmployee(employee);
			Employee response = eService.save(newEmployee);
			EmployeeDto dto = EmployeeMapper.mapToDto(response);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
		try {
			List<Department> listaDepartments = eService.findAllByOrderByDepartmentNameAsc();
			List<DepartmentDto> dtos = listaDepartments.stream().map(MioMapper::mapDepartmentToDto)
					.toList();
			if (listaDepartments.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/locations")
	public ResponseEntity<List<LocationDto>> getAllLocations() {
		try {
			List<Location> listaLocations = eService.findAllByOrderByCityAsc();
			List<LocationDto> dtos = listaLocations.stream().map(MioMapper::mapLocationToDto).toList();
			if (listaLocations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/countries")
	public ResponseEntity<List<CountryDto>> getAllCountries() {
		try {
			List<Countries> listaCountries = eService.findAllByOrderByCountryNameAsc();
			List<CountryDto> dtos = listaCountries.stream().map(MioMapper::mapCountryToDto).toList();
			if (listaCountries.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/regions")
	public ResponseEntity<List<Region>> getAllRegions() {
		try {
			List<Region> listaRegions = eService.findAllByOrderByRegionNameAsc();
			if (listaRegions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(listaRegions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/jobs")
	public ResponseEntity<List<JobDto>> getAllJobs() {
		try {
			List<Job> listaJobs = eService.findAllByOrderByJobTitleAsc();
			List<JobDto> dtos = listaJobs.stream().map(MioMapper::mapJobToDto).toList();
			if (listaJobs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		try {
			if (eService.findEmployeeById(id).isPresent()) {
				eService.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employee) {
		Optional<Employee> optionalEmployee = eService.findEmployeeById(id);
		Job existingJob = eService.findJobById(employee.getJobId())
				.orElseThrow(() -> new RuntimeException("Job non trovato"));
		Date parsedHireDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			parsedHireDate = sdf.parse(employee.getHireDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (optionalEmployee.isPresent()) {
			Employee newEmployee = new Employee(id, employee.getFirstName(), employee.getLastName(),
					employee.getEmail(), employee.getPhoneNumber(), parsedHireDate, existingJob, employee.getSalary(),
					employee.getDepartment());
			Employee updated = eService.save(newEmployee);
			EmployeeDto dto = EmployeeMapper.mapToDto(updated);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
