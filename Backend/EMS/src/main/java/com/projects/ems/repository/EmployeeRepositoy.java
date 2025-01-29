package com.projects.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.ems.entity.Employee;

public interface EmployeeRepositoy extends JpaRepository<Employee, Long> {

}
