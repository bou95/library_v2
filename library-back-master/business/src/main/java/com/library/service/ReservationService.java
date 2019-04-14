package com.library.service;

import com.library.model.entities.Books;
import com.library.model.entities.Reservation;
import com.library.model.entities.Users;

import java.util.List;

public interface ReservationService {

    boolean insert(Reservation reservation);

    Reservation getById(Long id);

    Reservation getByBookAndUser(Users user, Books book);

    List<Reservation> getAllReservations();

    void deleteById(Reservation reservation);

    List<Reservation> findAllByUser(Users user);

}
