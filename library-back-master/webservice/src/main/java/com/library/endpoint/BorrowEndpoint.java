package com.library.endpoint;

import com.library.model.entities.Books;
import com.library.model.entities.Borrow;
import com.library.service.BooksService;
import com.library.service.UsersService;
import com.library.ws.borrows.*;
import com.library.service.BorrowsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

@Endpoint
public class BorrowEndpoint {

    private static final String NAMESPACE_URI = "http://libraryservice/borrows";
    @Autowired
    private BorrowsService borrowsService;

    @Autowired
    BooksService booksService;

    @Autowired
    UsersService usersService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBorrowByIdRequest")
    @ResponsePayload
    public GetBorrowByIdResponse getBorrow(@RequestPayload GetBorrowByIdRequest request) throws DatatypeConfigurationException {
        GetBorrowByIdResponse response = new GetBorrowByIdResponse();
        Borrow borrow = borrowsService.getById(request.getBorrowId());
        BorrowInfo borrowInfo = setBorrowInfo(borrow);
        response.setBorrowInfo(borrowInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBorrowRequest")
    @ResponsePayload
    public AddBorrowResponse addBorrow(@RequestPayload AddBorrowRequest request) throws DatatypeConfigurationException {
        AddBorrowResponse response = new AddBorrowResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Borrow borrow = new Borrow();
        Books book = booksService.getBookById(request.getBookId());
        if (book.getAvailable() > 0) {
            borrow.setBook(book);
            borrow.setBorrower(usersService.getById(request.getUserId()));
            Date d = new Date();
            borrow.setTerm(weeksLater(d));
            borrow.setExtend(false);
            Long available = book.getAvailable() - 1L;
            book.setAvailable(available);
            booksService.update(book);
            boolean flag = borrowsService.insert(borrow);
            if (flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Le pret existe déja");
                response.setServiceStatus(serviceStatus);
            } else {
                BorrowInfo borrowInfo = setBorrowInfo(borrow);
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Le prêt a été créé");
                response.setServiceStatus(serviceStatus);
                response.setBorrowInfo(borrowInfo);
            }
        }else{
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Le livre n'est pas disponible");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "extendBorrowRequest")
    @ResponsePayload
    public ExtendBorrowResponse extendBorrow(@RequestPayload ExtendBorrowRequest request) throws DatatypeConfigurationException {
        Borrow borrow = borrowsService.getById(request.getBorrowId());
        ServiceStatus serviceStatus = new ServiceStatus();
        ExtendBorrowResponse response = new ExtendBorrowResponse();
        Date today = Calendar.getInstance().getTime();
        if(borrow.getExtend() == true || borrow.getTerm().before(today)) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Le prêt ne peut être prolongé");
            response.setServiceStatus(serviceStatus);
        } else {
            borrow.setExtend(true);
            borrow.setTerm(weeksLater(borrow.getTerm()));
            borrowsService.extendBorrow(borrow);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Le prêt a été prolongé");
            response.setServiceStatus(serviceStatus);
            BorrowInfo borrowInfo = setBorrowInfo(borrow);
            response.setBorrowInfo(borrowInfo);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBorrowRequest")
    @ResponsePayload
    public DeleteBorrowResponse deleteBorrow(@RequestPayload DeleteBorrowRequest request) {
        Borrow borrow = borrowsService.getById(request.getBorrowId());
        Books book = booksService.getBookById(borrow.getBook().getBook_id());
        Long available = book.getAvailable();
        ServiceStatus serviceStatus = new ServiceStatus();
        DeleteBorrowResponse response = new DeleteBorrowResponse();
        if (borrow == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Le prêt n'existe pas");
            response.setServiceStatus(serviceStatus);
        } else {
            book.setAvailable(available +1L);
            borrowsService.deleteById(request.getBorrowId());
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Le pret a été supprimé");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOutdatedBorrowsRequest")
    @ResponsePayload
    public GetAllOutdatedBorrowsResponse oudatedBorrows()throws DatatypeConfigurationException {
        GetAllOutdatedBorrowsResponse response = new GetAllOutdatedBorrowsResponse();
        List<Borrow> borrowList = new ArrayList<>();
        List<BorrowInfo> borrowInfoList = new ArrayList<>();
        for(Iterator<Borrow> borrowsIterator = borrowsService.getAllBorrow().iterator(); borrowsIterator.hasNext();){
            Borrow borrow = borrowsIterator.next();
            if (borrow.getTerm().compareTo(new Date()) < 0){
                borrowList.add(borrow);
            }
        }
        for (int i = 0; i < borrowList.size(); i++) {
            BorrowInfo ob = setBorrowInfo(borrowList.get(i));

            borrowInfoList.add(ob);
        }
        response.getBorrowInfo().addAll(borrowInfoList);
        return response;

    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBorrowsRequest")
    @ResponsePayload
    public GetAllBorrowsResponse getAllBorrows() throws DatatypeConfigurationException {
        GetAllBorrowsResponse response = new GetAllBorrowsResponse();
        List<BorrowInfo> borrowInfoList = new ArrayList<>();
        List<Borrow> borrowsList = borrowsService.getAllBorrow();
        for (int i = 0; i < borrowsList.size(); i++) {
            BorrowInfo ob = setBorrowInfo(borrowsList.get(i));

            borrowInfoList.add(ob);
        }
        response.getBorrowInfo().addAll(borrowInfoList);
        return response;
    }

    //Calcul pour obtenir la date de fin de pret Term 4 semaines après la date de creation
    private Date weeksLater(Date d){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.WEEK_OF_MONTH, 4);
        return c.getTime();
    }

    //
    private BorrowInfo setBorrowInfo(Borrow borrow) throws DatatypeConfigurationException {
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setBorrowId(borrow.getBorrow_id());
        borrowInfo.setTerm(convertDate(borrow.getTerm()));
        borrowInfo.setExtend(borrow.getExtend());
        //Ajout Users
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(borrow.getBorrower().getUser_id());
        BeanUtils.copyProperties(borrow.getBorrower(), userInfo, "password");
        //Ajout livre
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookId(borrow.getBook().getBook_id());
        BeanUtils.copyProperties(borrow.getBook(), bookInfo);

        borrowInfo.setBook(bookInfo);
        borrowInfo.setBorrower(userInfo);

        return borrowInfo;
    }

    private XMLGregorianCalendar convertDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar d = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return d;
    }
}
