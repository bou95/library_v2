package com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.consumer.repository.EmployeesRepo;
import com.library.model.entities.Employees;
import com.library.service.EmployeesService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	EmployeesRepo employeesRepo;
	
	@Override
    public synchronized boolean insert(Employees employee) {
		Employees employee1 = employeesRepo.findEmployeesByEmail(employee.getEmail());
		if (employee1 != null) {
			return false;
		}else {
		
		employeesRepo.save(employee);
		return true;
		}
	}
	
	@Override
    public void update(Employees employee) {
		employeesRepo.save(employee);
	}

	@Override
	public void delete(Employees employees){
		employeesRepo.delete(employees);
	}
	
	@Override
	public void deleteById(long id) {
		employeesRepo.delete(id);
	}
	
	@Override
	public Employees findById(long id) {
		return employeesRepo.findOne(id);
	}

	@Override
	public Employees login(String email, String password){
		return employeesRepo.findEmployeesByEmailAndPassword(email, password);
	}

}
