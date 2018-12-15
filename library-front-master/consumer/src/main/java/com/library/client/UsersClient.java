package com.library.client;

import com.library.wsdl.users.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UsersClient extends WebServiceGatewaySupport {

    public GetUserByIdResponse findUserById(long userId) {
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setUserId(userId);
        GetUserByIdResponse response = (GetUserByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getUserByIdRequest"));
        return response;
    }

    public AddUserResponse addUser(String email, String password, String lastName, String firstName) {
        AddUserRequest request = new AddUserRequest();
        request.setEmail(email);
        request.setPassword(password);
        request.setLastName(lastName);
        request.setFirstName(firstName);
        AddUserResponse response = (AddUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/addUserRequest"));
        return response;
    }
    public UpdateUserResponse updateUser(UserInfo userInfo) {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setUserInfo(userInfo);
        UpdateUserResponse response = (UpdateUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/updateUserRequest"));
        return response;
    }
    public DeleteUserResponse deleteUser(long userId) {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setUserId(userId);
        DeleteUserResponse response = (DeleteUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/deleteUserRequest"));
        return response;
    }

    public LoginUserResponse loginUser(String email, String password){
        LoginUserRequest request = new LoginUserRequest();
        request.setEmail(email);
        request.setPassword(password);
        LoginUserResponse response = (LoginUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/loginUserRequest"));
        return response;
    }
}
