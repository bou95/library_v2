package com.library.service;

import com.library.model.entities.Books;
import com.library.model.entities.Reservation;
import com.library.model.entities.Users;

public interface ReservationService {

    boolean insert(Long bookId, Long userId);

    Reservation getByBook(Long id);

    void deleteUserReservation(Long bookId, Long userId);

    void deleteById(Long id);

    boolean deleteByBook(Books book);

}
