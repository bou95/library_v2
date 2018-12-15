package com.library.endpoint;


import com.library.ws.users.*;
import com.library.model.entities.Borrow;
import com.library.model.entities.Users;
import com.library.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://libraryservice/users";
    @Autowired
    private UsersService usersService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserByid(@RequestPayload GetUserByIdRequest request) throws DatatypeConfigurationException {
        GetUserByIdResponse response = new GetUserByIdResponse();
        UserInfo userInfo = new UserInfo();
        Users user = usersService.getById(request.getUserId());
        BeanUtils.copyProperties(user, userInfo);
        userInfo.setUserId(user.getUser_id());
        List<BorrowInfo> borrowsList = new ArrayList<>();
        for (int i = 0; i < user.getBorrowList().size(); i++) {
            BorrowInfo ob = setBorrowInfo(user.getBorrowList().get(i));
            borrowsList.add(ob);
        }
        userInfo.getBorrowInfo().addAll(borrowsList);
        response.setUserInfo(userInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Users user = new Users();
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        boolean flag = usersService.insert(user);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("l'utilisateur existe déja");
            response.setServiceStatus(serviceStatus);
        } else {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(user, userInfo);
            userInfo.setUserId(user.getUser_id());
            response.setUserInfo(userInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("L'utilisateur a été crée.");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        Users user = usersService.getById(request.getUserInfo().getUserId());
        ServiceStatus serviceStatus = new ServiceStatus();
        UpdateUserResponse response = new UpdateUserResponse();
        if(user.getUser_id() == null){
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("L'utilisateur n'existe pas");
            response.setServiceStatus(serviceStatus);
        }else {
            BeanUtils.copyProperties(request.getUserInfo(), user);
            usersService.update(user);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("L'utilisateur a été mis a jour avec succès.");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        Users user = usersService.getById(request.getUserId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (user == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("L'utilisateur n'existe pas.");
        } else {
            usersService.delete(user.getUser_id());
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("L'utilisateur a été supprimé avec succes.");
        }
        DeleteUserResponse response = new DeleteUserResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginUserRequest")
    @ResponsePayload
    public LoginUserResponse login(@RequestPayload LoginUserRequest request){
        LoginUserResponse response = new LoginUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Users user = usersService.login(request.getEmail(), request.getPassword());
        if (user == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("L'utilisateur n'existe pas.");
            response.setServiceStatus(serviceStatus);
        } else {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(user, userInfo);
            userInfo.setUserId(user.getUser_id());
            response.setUserInfo(userInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Vous etes bien conneceté en tant que" + userInfo.getFirstName());
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    
    private BorrowInfo setBorrowInfo(Borrow borrow) throws DatatypeConfigurationException {
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setBorrowId(borrow.getBorrow_id());
        borrowInfo.setTerm(convertDate(borrow.getTerm()));
        borrowInfo.setExtend(borrow.getExtend());
        BookInfo bookInfo = new BookInfo();
        BeanUtils.copyProperties(borrow.getBook(), bookInfo);
        bookInfo.setBookId(borrow.getBorrow_id());
        borrowInfo.setBorrow(bookInfo);
        return borrowInfo;
    }
    
    private XMLGregorianCalendar convertDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar d = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return d;
    }
}