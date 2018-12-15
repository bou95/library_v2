package com.library.client;

import com.library.wsdl.borrows.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BorrowsClient extends WebServiceGatewaySupport {

    public AddBorrowResponse insert(long userId, long bookId){
        AddBorrowRequest request = new AddBorrowRequest();
        request.setBookId(bookId);
        request.setUserId(userId);
        AddBorrowResponse response = (AddBorrowResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/addBorrowRequest"));
        return response;
    }

    public GetBorrowByIdResponse findById(long id){
        GetBorrowByIdRequest request = new GetBorrowByIdRequest();
        request.setBorrowId(id);
        GetBorrowByIdResponse response = (GetBorrowByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getBorrrowByIdRequest"));
        return response;
    }

    public GetAllBorrowsResponse findAllBorrows(){
        GetAllBorrowsRequest request = new GetAllBorrowsRequest();
        GetAllBorrowsResponse response = (GetAllBorrowsResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getAllBorrowsRequest"));
        return response;
    }

    public ExtendBorrowResponse extend(long id){
        ExtendBorrowRequest request = new ExtendBorrowRequest();
        request.setBorrowId(id);
        ExtendBorrowResponse response =(ExtendBorrowResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/extendBorrowRequest"));
        return response;
    }

    public DeleteBorrowResponse delete(long id){
        DeleteBorrowRequest request = new DeleteBorrowRequest();
        request.setBorrowId(id);
        DeleteBorrowResponse response = (DeleteBorrowResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/DeleteBorrowRequest"));
        return response;
    }
}