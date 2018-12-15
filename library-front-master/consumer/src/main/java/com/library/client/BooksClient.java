package com.library.client;

import com.library.wsdl.books.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BooksClient extends WebServiceGatewaySupport {

    public GetBookByIdResponse findBookById(long bookId) {
        GetBookByIdRequest request = new GetBookByIdRequest();
        request.setBookId(bookId);
        GetBookByIdResponse response = (GetBookByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getBookByIdRequest"));
        return response;
    }

    public GetAllBooksResponse findAllBooks() {
        GetAllBooksRequest request = new GetAllBooksRequest();
        GetAllBooksResponse response = (GetAllBooksResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/getAllBooksRequest"));
        return response;
    }

    public AddBookResponse insertBook(String title, String category, String author, long available) {
        AddBookRequest request = new AddBookRequest();
        request.setTitle(title);
        request.setCategory(category);
        request.setAuthor(author);
        request.setAvailable(available);
        AddBookResponse response = (AddBookResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/addBookRequest"));
        return response;
    }

    public UpdateBookResponse updateBook(BookInfo bookInfo) {
        UpdateBookRequest request = new UpdateBookRequest();
        request.setBookInfo(bookInfo);
        UpdateBookResponse response = (UpdateBookResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/updateBookRequest"));
        return response;
    }

    public DeleteBookResponse deleteBook(long bookId) {
        DeleteBookRequest request = new DeleteBookRequest();
        request.setBookId(bookId);
        DeleteBookResponse response = (DeleteBookResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/deleteBookRequest"));
        return response;
    }

    public SearchBookResponse searchBooks(String author, String title){
        SearchBookRequest request = new SearchBookRequest();
        request.setAuthor(author);
        request.setTitle(title);
        SearchBookResponse response =(SearchBookResponse)getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/searchBookRequest"));
        return response;
    }
}
