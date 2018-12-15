package com.library.service.impl;

import com.library.client.BorrowsClient;
import com.library.service.BorrowsService;
import com.library.wsdl.borrows.*;
import entities.Books;
import entities.Borrows;
import entities.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowsServiceImpl implements BorrowsService {

    @Autowired
    BorrowsClient client;

    @Override
    public Borrows create(long userId, long bookId){
        AddBorrowResponse response = client.insert(userId, bookId);
        BorrowInfo borrowInfo = response.getBorrowInfo();
        Borrows borrows = setBorrows(borrowInfo);
        return borrows;
    }

    @Override
    public Borrows extend(long borrowId){
        ExtendBorrowResponse response = client.extend(borrowId);
        BorrowInfo borrowInfo = response.getBorrowInfo();
        Borrows borrows = setBorrows(borrowInfo);
        return borrows;
    }

    @Override
    public ServiceStatus delete(long id){
        DeleteBorrowResponse response = client.delete(id);
        return response.getServiceStatus();
    }

    @Override
    public Borrows getById(long id){
        GetBorrowByIdResponse response = client.findById(id);
        BorrowInfo borrowInfo = response.getBorrowInfo();
        Borrows borrows = setBorrows(borrowInfo);
        return borrows;
    }

    @Override
    public List<Borrows> getAllBorrow(){
        GetAllBorrowsResponse response = client.findAllBorrows();
        List<BorrowInfo> borrowInfoList = response.getBorrowInfo();
        List<Borrows> borrowsList = new ArrayList<>();
        return borrowsList;
    }

    public Borrows setBorrows(BorrowInfo borrowInfo) {
        //users
        Users users = new Users();
        users.setUser_id(borrowInfo.getBorrower().getUserId());
        BeanUtils.copyProperties(borrowInfo.getBorrower(), users);
        //books
        Books books = new Books();
        books.setBook_id(borrowInfo.getBorrowId());
        BeanUtils.copyProperties(borrowInfo.getBook(), books);

        Borrows borrows = new Borrows();
        borrows.setBorrow_Id(borrowInfo.getBorrowId());
        borrows.setExtend(borrowInfo.isExtend());
        borrows.setTerm(borrowInfo.getTerm());
        borrows.setBook(books);
        borrows.setBorrower(users);

        return borrows;
    }
}
