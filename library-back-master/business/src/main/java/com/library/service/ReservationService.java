package com.library.service;

import com.library.model.entities.Books;
import com.library.model.entities.Reservation;
import com.library.model.entities.Users;

public interface ReservationService {

    boolean insert(Reservation reservation);

    Reservation getById(Long id);

    void deleteById(Long id);


}
