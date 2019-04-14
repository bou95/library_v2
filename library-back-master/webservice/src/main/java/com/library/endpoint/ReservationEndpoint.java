package com.library.endpoint;

import com.library.model.entities.Books;
import com.library.model.entities.Reservation;
import com.library.model.entities.Users;
import com.library.service.BooksService;
import com.library.service.ReservationService;
import com.library.service.UsersService;
import com.library.ws.reservations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ReservationEndpoint {

    private static final String NAMESPACE_URI = "http://libraryservice/reservations";
    @Autowired
    ReservationService service;
    @Autowired
    BooksService booksService;
    @Autowired
    UsersService usersService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addReservationRequest")
    @ResponsePayload
    public AddReservationResponse addReservation(@RequestPayload AddReservationRequest request){
        AddReservationResponse response = new AddReservationResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Books book = booksService.getBookById(request.getBookId());
        Users user = usersService.getById(request.getUserId());
        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setBorrowers(user);
        reservation.setIndex(book.getReservation().size() + 1);
        if(book.getAvailable() <= 0 & reservation.getBook().getReservation().size() < (2 * reservation.getBook().getBorrowList().size()) ){
            boolean flag = service.insert(reservation);
            if (flag == false){
                serviceStatus.setStatusCode("FAIL");
                serviceStatus.setMessage("Vous avez déjà réserver ce livre");
                response.setServiceStatus(serviceStatus);
            } else {
                serviceStatus.setStatusCode("SUCCES");
                serviceStatus.setMessage("Votre réservation a été créé");
                ReservationInfo reservationInfo = setReservationInfo(reservation);
                response.setServiceStatus(serviceStatus);
                response.setReservationInfo(reservationInfo);
            }
        }else{
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Imposssible de réserver ce livre");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getReservationByIdRequest")
    @ResponsePayload
    public GetReservationByIdResponse getReservationById(@RequestPayload GetReservationByIdRequest request){
        GetReservationByIdResponse response = new GetReservationByIdResponse();
        Reservation reservation = service.getById(request.getResId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if(reservation == null){
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Aucune réservation ne correspond");
            response.setServiceStatus(serviceStatus);
        }else{
            ReservationInfo reservationInfo = setReservationInfo(reservation);
            serviceStatus.setStatusCode("SUCCES");
            response.setServiceStatus(serviceStatus);
            response.setReservationInfo(reservationInfo);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReservationsRequest")
    @ResponsePayload
    public GetAllReservationsByUserResponse getALL(@RequestPayload GetAllReservationsRequest request){
        GetAllReservationsByUserResponse response = new GetAllReservationsByUserResponse();
        List<ReservationInfo> reservationInfoList = new ArrayList<>();
        List<Reservation> reservations = service.getAllReservations();
        for(int i = 0; i < reservations.size(); i++){
            ReservationInfo res = setReservationInfo(reservations.get(i));
            reservationInfoList.add(res);
        }
        response.getReservationInfo().addAll(reservationInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReservationsByUserRequest")
    @ResponsePayload
    public GetAllReservationsByUserResponse allByUser(@RequestPayload GetAllReservationsByUserRequest request){
        GetAllReservationsByUserResponse response = new GetAllReservationsByUserResponse();
        List<ReservationInfo> reservationInfoList = new ArrayList<>();
        Users user = usersService.getById(request.getUserId());
        List<Reservation> reservations = service.findAllByUser(user);
        for(int i = 0; i < reservations.size(); i++){
            ReservationInfo res = setReservationInfo(reservations.get(i));
            reservationInfoList.add(res);
        }
        response.getReservationInfo().addAll(reservationInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteReservationRequest")
    @ResponsePayload
    public DeleteReservationResponse deleteReservation(@RequestPayload DeleteReservationRequest request){
        DeleteReservationResponse response = new DeleteReservationResponse();
        Reservation reservation = service.getById(request.getResId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (reservation == null){
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("La réservation n'existe pas");
            response.setServiceStatus(serviceStatus);
        }else{
            service.deleteById(reservation);
            serviceStatus.setStatusCode("SUCCES");
            serviceStatus.setMessage("La réservation a été supprimée");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

    private ReservationInfo setReservationInfo(Reservation reservation){
        ReservationInfo reservationInfo = new ReservationInfo();
        reservationInfo.setResId(reservation.getRes_id());
        reservationInfo.setIndex(reservation.getIndex());

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(reservation.getBorrowers().getUser_id());
        BeanUtils.copyProperties(reservation.getBorrowers(), userInfo,"password");

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookId(reservation.getBook().getBook_id());
        BeanUtils.copyProperties(reservation.getBook(), bookInfo);

        reservationInfo.setBook(bookInfo);
        reservationInfo.setBorrowers(userInfo);
        return reservationInfo;
    }
}
