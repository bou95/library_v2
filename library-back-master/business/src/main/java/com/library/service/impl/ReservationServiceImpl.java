package com.library.service.impl;

import com.library.consumer.repository.BooksRepo;
import com.library.consumer.repository.ReservationRepo;
import com.library.consumer.repository.UsersRepo;
import com.library.model.entities.Books;
import com.library.model.entities.Reservation;
import com.library.model.entities.Users;
import com.library.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.TreeMap;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepo repo;

    @Autowired
    BooksRepo bookRepo;

    @Autowired
    UsersRepo userRepo;

    @Override
    public boolean insert(Long bookId, Long userId) {
        Books book = bookRepo.getOne(bookId);
        Users user = userRepo.getOne(userId);
        TreeMap<Long, Users> tm = new TreeMap<>();
        Long maximum = book.getAvailable() * 2L;
        Reservation reservation = repo.findReservationWithbook_id(book.getBook_id());
        if(reservation == null){
            reservation.setAssigned_book(book);
            tm.put(1L, user);
            reservation.setBorrowers(tm);
            repo.save(reservation);
            return true;
        }if (reservation != null & reservation.getBorrowers().containsValue(user) == false){
            Long key = reservation.getBorrowers().lastKey()+1L;
            if(key < maximum){
                tm.put(key, user);
                reservation.setBorrowers(tm);
                repo.save(reservation);
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public Reservation getByBook(Long id) {
        Reservation reservation = repo.findReservationWithbook_id(id);
        return reservation;
    }

    @Override
    public void deleteUserReservation(Long bookId, Long userId) {
        Books book = bookRepo.getOne(bookId);
        Users user = userRepo.getOne(userId);
        Reservation reservation = repo.findReservationWithbook_id(book.getBook_id());
        if(reservation.getBorrowers().containsValue(user) == true){
            Long key = reservation.getBorrowers().firstKey();
            reservation.getBorrowers().remove(key);
        }
    }

    @Override
    public void deleteById(Long id) {
        repo.delete(id);
    }

    @Override
    public boolean deleteByBook(Books book) {
        Reservation reservation = repo.findReservationWithbook_id(book.getBook_id());
        if (reservation != null & reservation.getBorrowers().isEmpty()){
            repo.delete(reservation.getRes_id());
            return true;
        }else{
            return false;
        }
    }

}
