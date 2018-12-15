package com.library.service;

import com.library.model.entities.Employees;

public interface EmployeesService {

	boolean insert(Employees employee);

	void update(Employees employee);

	void delete(Employees employees);

	void deleteById(long id);

	Employees findById(long id);

    Employees login(String email, String password);
}
