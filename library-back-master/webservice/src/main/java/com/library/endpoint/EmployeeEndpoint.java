package com.library.endpoint;

import com.library.ws.employees.*;
import com.library.model.entities.Employees;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.library.service.EmployeesService;

@Endpoint
public class EmployeeEndpoint {
	
    private static final String NAMESPACE_URI = "http://libraryservice/employees";
    @Autowired
    private EmployeesService employeesService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeByIdResponse getEmployeeById(@RequestPayload GetEmployeeByIdRequest request) {
        GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        BeanUtils.copyProperties(employeesService.findById(request.getEmployeeId()), employeeInfo);
        response.setEmployeeInfo(employeeInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
        AddEmployeeResponse response = new AddEmployeeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Employees employee = new Employees();
        employee.setLastName(request.getLastName());
        employee.setFirstName(request.getFirstName());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        boolean flag = employeesService.insert(employee);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            BeanUtils.copyProperties(employee, employeeInfo);
            employeeInfo.setEmployeeId(employee.getEmployee_id());
            response.setEmployeeInfo(employeeInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        Employees employee = new Employees();
        BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
        employeesService.update(employee);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
        Employees employee = employeesService.findById(request.getEmployeeId());
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        if (employee == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
            response.setServiceStatus(serviceStatus);
        } else {
            employeesService.delete(employee);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

}
