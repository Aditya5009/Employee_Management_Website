package com.projects.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projects.ems.dto.EmployeeDto;
import com.projects.ems.entity.Employee;
import com.projects.ems.exception.ResourceNotFoundException;
import com.projects.ems.mapper.EmployeeMappper;
import com.projects.ems.repository.EmployeeRepositoy;
import com.projects.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepositoy employeeRepositoy;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMappper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepositoy.save(employee);

		return EmployeeMappper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {

		Employee employee = employeeRepositoy.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + employeeId + " Id not found."));

		return EmployeeMappper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {

		List<Employee> employees = employeeRepositoy.findAll();

		return employees.stream().map((employee) -> EmployeeMappper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

		Employee employee = employeeRepositoy.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee with id " + employeeId + "does not exists."));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepositoy.save(employee);

		return EmployeeMappper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepositoy.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee with id " + employeeId + "does not exists."));

		employeeRepositoy.deleteById(employeeId);

	}

}
