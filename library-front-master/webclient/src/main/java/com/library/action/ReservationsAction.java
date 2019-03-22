package com.library.action;

import com.library.service.BooksService;
import com.library.service.ReservationService;
import com.library.service.UsersService;
import com.library.wsdl.reservations.BookInfo;
import com.library.wsdl.reservations.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import entities.Reservation;
import entities.Users;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ReservationsAction extends ActionSupport implements SessionAware {

    @Autowired
    ReservationService service;
    @Autowired
    UsersService usersService;
    @Autowired
    BooksService booksService;

    private long id;

    private BookInfo bookInfo;

    private UserInfo userInfo;

    private Integer index;

    private Reservation reservations;

    private List<Reservation> reservationList;

    private Map<String, Object> session;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public String doCreate() {
        String Result = ActionSupport.INPUT;
        Users log = (Users) session.get("user");

        if (log == null) {
            this.addActionError("Merci de vous connecter pour empruntez un livre");
            Result = ActionSupport.ERROR;
        }
        try {
            reservations = service.create(log.getUser_id(), bookInfo.getBookId());
            if (reservations != null) {
                Result = ActionSupport.SUCCESS;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return Result;
    }

    public String getById(){
        if (id < 1) {
            this.addActionError("Vous devez indiquer un id ");
        } else {
            reservations = service.getById(id);
            return ActionSupport.SUCCESS;
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String cancelReservation(){
        //String result = ActionSupport.INPUT;
        Users log = (Users) session.get("user");

        if (log == null) {
            this.addActionError("Merci de vous connecter pour annuler une réservation");
            //result = ActionSupport.ERROR;
        }try {
            Users users = usersService.getUserById(log.getUser_id());
            //reservations = service.getById(id);
            service.deleteById(reservations.getRes_Id());
            //result = ActionSupport.SUCCESS;
        }catch (Exception e){
            this.addActionError("la réservation n'existe pas");
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
