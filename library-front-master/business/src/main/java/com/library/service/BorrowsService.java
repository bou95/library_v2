package com.library.service;

import com.library.wsdl.borrows.BorrowInfo;
import com.library.wsdl.borrows.ServiceStatus;
import entities.Borrows;

import java.util.List;

public interface BorrowsService {
    Borrows create(long userId, long bookId);

    Borrows extend(long borrowId);

    ServiceStatus delete(long id);

    Borrows getById(long id);

    List<Borrows> getAllBorrow();
}
