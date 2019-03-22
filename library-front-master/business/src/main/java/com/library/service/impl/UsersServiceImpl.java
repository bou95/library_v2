package com.library.service.impl;


import com.library.client.UsersClient;
import com.library.service.UsersService;
import com.library.wsdl.users.*;
import entities.Books;
import entities.Borrows;
import entities.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersClient client;

    @Override
    public Users create(String email, String password, String lastName, String firstName){
        AddUserResponse response = client.addUser(email, password, lastName, firstName);
        UserInfo userInfo = response.getUserInfo();
        Users user = new Users();
        BeanUtils.copyProperties(userInfo, user);
        user.setUser_id(userInfo.getUserId());
        return user;

    }

    @Override
    public Users getUserById(long id){
        GetUserByIdResponse response = client.findUserById(id);
        UserInfo userInfo = response.getUserInfo();
        Users users = new Users();
        BeanUtils.copyProperties(userInfo, users);
        users.setUser_id(userInfo.getUserId());
        List<Borrows> borrowsList = new ArrayList<>();
        for (int i = 0; i < userInfo.getBorrowInfo().size(); i++){
            Borrows ob = setBorrow(userInfo.getBorrowInfo().get(i));
            borrowsList.add(ob);
        }
        users.setBorrows(borrowsList);
        return users;
    }

    @Override
    public ServiceStatus delete(long id){
        DeleteUserResponse response = client.deleteUser(id);
        return response.getServiceStatus();
    }

    @Override
    public ServiceStatus update(Users user){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        userInfo.setUserId(user.getUser_id());
        UpdateUserResponse response = client.updateUser(userInfo);
        return response.getServiceStatus();
    }

    @Override
    public Users login(String email, String password){
        LoginUserResponse response = client.loginUser(email, password);
        UserInfo userInfo = response.getUserInfo();
        Users user = new Users();
        BeanUtils.copyProperties(userInfo, user);
        user.setUser_id(userInfo.getUserId());
        return user;
    }

    @Override
    public Users remind(long id, boolean reminder) {
        RemindCheckboxResponse response = client.remind(id, reminder);
        UserInfo userInfo = response.getUserInfo();
        Users user = new Users();
        BeanUtils.copyProperties(userInfo, user);
        user.setUser_id(userInfo.getUserId());
        user.setReminder(userInfo.isReminder());
        return user;
    }

    private Borrows setBorrow(BorrowInfo borrowInfo){
        Borrows borrows = new Borrows();
        borrows.setBorrow_Id(borrowInfo.getBorrowId());
        borrows.setTerm(borrowInfo.getTerm());
        borrows.setExtend(borrowInfo.isExtend());
        Books book = new Books();
        BeanUtils.copyProperties(borrowInfo.getBorrow(), book);
        book.setBook_id(borrowInfo.getBorrow().getBookId());
        borrows.setBook(book);
        return borrows;
    }

}
