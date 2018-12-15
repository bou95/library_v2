package com.library.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.model.entities.Employees;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees, Long> {
	Employees findEmployeesByEmail(String email);
	Employees findEmployeesByEmailAndPassword(String email, String password);
}
