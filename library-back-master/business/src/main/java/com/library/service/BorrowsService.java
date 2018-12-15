package com.library.service;

import com.library.model.entities.Borrow;

import java.util.List;

public interface BorrowsService {
    boolean insert(Borrow borrow);

    void updateById(long id);

    void update(Borrow borrow);

    void delete(Borrow borrow);

    void deleteById(long id);

    Borrow getById(long id);

    List<Borrow> getAllBorrow();

    void extendBorrow(Borrow borrow);
}
