package com.projects.ems.mapper;

import com.projects.ems.dto.EmployeeDto;
import com.projects.ems.entity.Employee;

public class EmployeeMappper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	};

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail());
	};

}