package com.library.service.impl;

import com.library.client.ReservationClient;
import com.library.service.ReservationService;
import com.library.wsdl.reservations.*;
import entities.Books;
import entities.Reservation;
import entities.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationClient client;

    @Override
    public Reservation create (long userId, long bookId){
        AddReservationResponse response = client.insert(userId, bookId);
        Reservation reservation = setReservation(response.getReservationInfo());
        return reservation;
    }

    @Override
    public Reservation getById(long id){
        GetReservationByIdResponse response = client.findById(id);
        Reservation reservation = setReservation(response.getReservationInfo());
        return reservation;
    }

    @Override
    public ServiceStatus deleteById(long id){
        DeleteReservationResponse response = client.delete(id);
        return response.getServiceStatus();
    }

    @Override
    public List<Reservation> getAllReservationsByUser(long id) {
        GetAllReservationsByUserResponse response = client.allByUser(id);
        List<ReservationInfo> reservationInfoList = response.getReservationInfo();
        List<Reservation> reservations = new ArrayList<>();
        for(int i=0; i < reservationInfoList.size(); i++){
            Reservation reservation = setReservation(reservationInfoList.get(i));
            reservations.add(reservation);
        }
        return reservations;
    }


    private Reservation setReservation(ReservationInfo reservationInfo){
        Reservation reservation = new Reservation();
        reservation.setRes_Id(reservationInfo.getResId());
        reservation.setIndex(reservationInfo.getIndex());

        Users user = new Users();
        user.setUser_id(reservationInfo.getBorrowers().getUserId());
        BeanUtils.copyProperties(reservationInfo.getBorrowers(), user,"password");

        Books book = new Books();
        book.setBook_id(reservationInfo.getBook().getBookId());
        BeanUtils.copyProperties(reservationInfo.getBook(), book);

        reservation.setBook(book);
        reservation.setBorrower(user);

        return reservation;
    }

}
