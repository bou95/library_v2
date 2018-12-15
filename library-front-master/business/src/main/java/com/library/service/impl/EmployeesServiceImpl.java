package com.library.service.impl;

import com.library.client.EmployeesClient;
import com.library.service.EmployeesService;
import com.library.wsdl.employees.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesClient client;

    @Override
    public EmployeeInfo create(String lastName, String firstName, String password, String email){
        AddEmployeeResponse response = client.insert(lastName, firstName, password, email);
        return response.getEmployeeInfo();
    }

    @Override
    public EmployeeInfo getById(long id){
        GetEmployeeByIdResponse response = client.findById(id);
        return response.getEmployeeInfo();
    }

    @Override
    public ServiceStatus update(EmployeeInfo employeeInfo){
        UpdateEmployeeResponse response = client.update(employeeInfo);
        return response.getServiceStatus();
    }

    @Override
    public ServiceStatus delte(long id){
        DeleteEmployeeResponse response = client.delete(id);
        return response.getServiceStatus();
    }
}
