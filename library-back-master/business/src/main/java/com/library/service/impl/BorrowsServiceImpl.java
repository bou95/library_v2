package com.library.service.impl;

import com.library.consumer.repository.BorrowRepo;
import com.library.model.entities.Borrow;
import com.library.service.BorrowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BorrowsServiceImpl implements BorrowsService {

    @Autowired
    BorrowRepo borrowRepo;


    @Override
    public synchronized boolean insert (Borrow borrow) {
        Borrow borrow1 = borrowRepo.findBorrowByBookAndAndBorrower(borrow.getBook(), borrow.getBorrower());
        if(borrow1 != null){
            return false;
        }else {
            borrowRepo.save(borrow);
            return true;
        }
    }

    @Override
    public void updateById(long id){
        Borrow borrow = borrowRepo.findOne(id);
        if (borrow != null){
            borrowRepo.save(borrow);
        }
    }

    @Override
    public void update(Borrow borrow) {borrowRepo.save(borrow);
    }

    @Override
    public void delete (Borrow borrow){
        borrowRepo.delete(borrow);
    }

    @Override
    public  void deleteById(long id){
        borrowRepo.delete(id);
    }

    @Override
    public Borrow getById(long id){
        return borrowRepo.findOne(id);
    }

    @Override
    public List<Borrow> getAllBorrow(){
        return borrowRepo.findAll();
    }

    @Override
    public void extendBorrow(Borrow borrow){
        borrowRepo.save(borrow);
    }
}
