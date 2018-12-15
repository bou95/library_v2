package com.library.service;

import com.library.wsdl.employees.EmployeeInfo;
import com.library.wsdl.employees.ServiceStatus;

public interface EmployeesService {
    EmployeeInfo create(String lastName, String firstName, String password, String email);

    EmployeeInfo getById(long id);

    ServiceStatus update(EmployeeInfo employeeInfo);

    ServiceStatus delte(long id);
}
