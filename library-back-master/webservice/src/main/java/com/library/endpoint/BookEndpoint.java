package com.library.endpoint;

import com.library.ws.books.*;
import com.library.model.entities.Books;
import com.library.service.BooksService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Endpoint
public class BookEndpoint {
    private static final String NAMESPACE_URI = "http://libraryservice/books";
    @Autowired
    private BooksService booksService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookByIdRequest")
    @ResponsePayload
    public GetBookByIdResponse getBookById(@RequestPayload GetBookByIdRequest request) {
        GetBookByIdResponse response = new GetBookByIdResponse();
        BookInfo bookInfo = new BookInfo();
        Books book = booksService.getBookById(request.getBookId());
        BeanUtils.copyProperties(book, bookInfo);
        bookInfo.setBookId(book.getBook_id());
        response.setBookInfo(bookInfo);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBooksRequest")
    @ResponsePayload
    public GetAllBooksResponse getAllBooks() {
        GetAllBooksResponse response = new GetAllBooksResponse();
        List<Books> booksList = booksService.getAllBooks();
        List<BookInfo> bookInfoList = books(booksList);
        response.getBookInfo().addAll(bookInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBookRequest")
    @ResponsePayload
    public SearchBookResponse searchBook(@RequestPayload SearchBookRequest request) {
        SearchBookResponse response = new SearchBookResponse();

        List<Books> booksList = booksService.searchBookByTitleAndAuthor(request.getTitle(),request.getAuthor());
        List<BookInfo> bookInfoList = books(booksList);
        response.getBookInfo().addAll(bookInfoList);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        AddBookResponse response = new AddBookResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Books book = new Books();
        book.setTitle(request.getTitle());
        book.setCategory(request.getCategory());
        book.setAuthor(request.getAuthor());
        book.setAvailable(request.getAvailable());
        boolean flag = booksService.insert(book);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(book.getBook_id());
            BeanUtils.copyProperties(book, bookInfo);
            response.setBookInfo(bookInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBookRequest")
    @ResponsePayload
    public UpdateBookResponse updateBook(@RequestPayload UpdateBookRequest request) {
        Books book = booksService.getBookById(request.getBookInfo().getBookId());
        ServiceStatus serviceStatus = new ServiceStatus();
        UpdateBookResponse response = new UpdateBookResponse();
        if (book.getBook_id() == null){
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Le livre a mettre a jour n'existe pas");
            response.setServiceStatus(serviceStatus);
        }else{
            BeanUtils.copyProperties(request.getBookInfo(), book);
            booksService.update(book);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Updated Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBookRequest")
    @ResponsePayload
    public DeleteBookResponse deleteBook(@RequestPayload DeleteBookRequest request) {
        Books book = booksService.getBookById(request.getBookId());
        DeleteBookResponse response = new DeleteBookResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        if (book == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Le livre n'existe pas");
            response.setServiceStatus(serviceStatus);
        } else {
            booksService.delete(book);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Le livre a été supprimé.");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

    private List<BookInfo> books(List<Books> booksList){
        List<BookInfo> books = new ArrayList<>();
        for (int i = 0; i < booksList.size(); i++) {
            BookInfo ob = new BookInfo();
            BeanUtils.copyProperties(booksList.get(i), ob);
            ob.setBookId(booksList.get(i).getBook_id());
            ob.setReservationListSize(booksList.get(i).getReservation().size());
            ob.setBorrowListSize(booksList.get(i).getBorrowList().size());
            books.add(ob);
        }
        return books;
    }
}