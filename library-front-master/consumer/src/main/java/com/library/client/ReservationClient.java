package com.library.client;

import com.library.wsdl.employees.GetEmployeeByIdRequest;
import com.library.wsdl.reservations.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ReservationClient extends WebServiceGatewaySupport {

    public AddReservationResponse insert(long userId, long bookId){
        AddReservationRequest request = new AddReservationRequest();
        request.setUserId(userId);
        request.setBookId(bookId);
        AddReservationResponse response = (AddReservationResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/addReservationRequest"));
        return response;
    }

    public GetReservationByIdResponse findById(long id){
        GetReservationByIdRequest request = new GetReservationByIdRequest();
        request.setResId(id);
        GetReservationByIdResponse response = (GetReservationByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getReservationByIdRequest"));
        return response;
    }

    public DeleteReservationResponse delete(long id){
        DeleteReservationRequest request = new DeleteReservationRequest();
        request.setResId(id);
        DeleteReservationResponse response = (DeleteReservationResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/DeleteReservationRequest"));
        return response;
    }

    public GetAllReservationsByUserResponse allByUser(long id){
        GetAllReservationsByUserRequest request = new GetAllReservationsByUserRequest();
        request.setUserId(id);
        GetAllReservationsByUserResponse response = (GetAllReservationsByUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getAllReservationsByUserRequest"));
        return  response;
    }

}
