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

import java.util.List;
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
    public boolean insert(Reservation reservation) {
        Reservation res = repo.findReservationByBookAndBorrowers(reservation.getBook(), reservation.getBorrowers());
        if (res !=null){
            return false;
        }else {
            repo.save(reservation);
            return true;
        }
    }

    @Override
    public Reservation getById(Long id) {
        Reservation reservation = repo.findOne(id);
        return reservation;
    }

    @Override
    public Reservation getByBookAndUser(Users user, Books book) {
        Reservation res = repo.findReservationByBookAndBorrowers(book, user);
        return res;
    }

    @Override
    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = repo.findAll();
        return reservations;
    }

    @Override
    public void deleteById(Reservation reservation) {
        repo.delete(reservation);
    }

    @Override
    public List<Reservation> findAllByUser(Users user) {
        List<Reservation> reservations = repo.findAllReservationsByBorrowers(user);
        return reservations;
    }


}
