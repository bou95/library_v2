package com.library.client;

import com.library.wsdl.employees.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class EmployeesClient extends WebServiceGatewaySupport {

    public AddEmployeeResponse insert(String email, String lastName, String firstName, String password ){
        AddEmployeeRequest request = new AddEmployeeRequest();
        request.setEmail(email);
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setPassword(password);
        AddEmployeeResponse response = (AddEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/addEmployeeRequest"));
        return response;
    }

    public GetEmployeeByIdResponse findById(long id){
        GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
        request.setEmployeeId(id);
        GetEmployeeByIdResponse response = (GetEmployeeByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getEmployeeByIdRequest"));
        return response;
    }


    public UpdateEmployeeResponse update(EmployeeInfo employeeInfo){
        UpdateEmployeeRequest request = new UpdateEmployeeRequest();
        request.setEmployeeInfo(employeeInfo);
        UpdateEmployeeResponse response =(UpdateEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/UpdateEmployeeRequest"));
        return response;
    }

    public DeleteEmployeeResponse delete(long id){
        DeleteEmployeeRequest request = new DeleteEmployeeRequest();
        request.setEmployeeId(id);
        DeleteEmployeeResponse response = (DeleteEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/DeleteEmployeeRequest"));
        return response;
    }
}
