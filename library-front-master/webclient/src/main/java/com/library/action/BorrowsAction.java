package com.library.action;

import com.library.service.BooksService;
import com.library.service.BorrowsService;
import com.library.service.UsersService;
import com.library.wsdl.borrows.BookInfo;
import com.library.wsdl.borrows.BorrowInfo;
import com.library.wsdl.borrows.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.Borrows;
import entities.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BorrowsAction extends ActionSupport implements SessionAware {

    @Autowired
    BorrowsService borrowsService;

    @Autowired
    BooksService booksService;

    @Autowired
    UsersService usersService;

    private long id;

    private BookInfo bookInfo;

    private UserInfo userInfo;

    private Date term;

    private Boolean extend;

    private Borrows borrows;

    private Map<String, Object> session;

    private List<Borrows> borrowList;

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

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public Boolean getExtend() {
        return extend;
    }

    public void setExtend(Boolean extend) {
        this.extend = extend;
    }

    public Borrows getBorrows() {
        return borrows;
    }

    public void setBorrows(Borrows borrows) {
        this.borrows = borrows;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public List<Borrows> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrows> borrowList) {
        this.borrowList = borrowList;
    }

    public String doCreate(){
        String Result = ActionSupport.INPUT;
        Users user = (Users) session.get("user");
        //Long userId = Long.parseLong(session().get("userId").toString());
        if (user == null){
            this.addActionError("Merci de vous connecter pour empruntez un livre");
            Result = ActionSupport.ERROR;
        }
        try{
            borrows = borrowsService.create(user.getUser_id(), bookInfo.getBookId());
            if (borrows != null) {
                Result = ActionSupport.SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result;
    }

    public String getById(){
        if (id < 1) {
            this.addActionError("Vous devez indiquer un id ");
        } else {
            borrows = borrowsService.getById(id);
            return ActionSupport.SUCCESS;
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String getAllBorrows(){
        borrowList = borrowsService.getAllBorrow();
        if(borrowList.size() <1){
            this.addActionError("Il n'y aucun pret");
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String extend(){
        String Result = ActionSupport.INPUT;
        Users user = (Users) session.get("user");
        Users users = usersService.getUserById(user.getUser_id());
        borrowList = users.getBorrows();
        if (user == null){
            this.addActionError("Merci de vous connecter pour emprunter ou prolonger un livre");
            Result = ActionSupport.ERROR;
        }
        try {
            borrowsService.extend(borrows.getBorrow_Id());
            Result = ActionSupport.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.session = sessionMap;
    }
}
