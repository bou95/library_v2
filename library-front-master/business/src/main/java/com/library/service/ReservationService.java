package com.library.service;


import com.library.wsdl.reservations.ServiceStatus;
import entities.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation create(long userId, long bookId);

    Reservation getById(long id);

    ServiceStatus deleteById(long id);

    List<Reservation> getAllReservationsByUser(long id);

    List<Reservation> getAllReservations();
}
