package com.library.service;


import com.library.wsdl.users.ServiceStatus;
import com.library.wsdl.users.UserInfo;
import entities.Users;

public interface UsersService {
    Users create(String email, String password, String lastName, String firstName);

    Users getUserById(long id);

    ServiceStatus delete(long id);

    ServiceStatus update(Users user);

    Users login(String email, String password);
}
