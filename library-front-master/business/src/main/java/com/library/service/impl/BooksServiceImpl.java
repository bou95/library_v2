package com.library.service.impl;

import com.library.client.BooksClient;
import com.library.service.BooksService;
import com.library.wsdl.books.*;
import entities.Books;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksClient client;

    @Override
    public Books create(String title, String category, String author, long available){
        AddBookResponse response = client.insertBook(title, category, author, available);
        BookInfo bookInfo = response.getBookInfo();
        Books books = new Books();
        books.setBook_id(bookInfo.getBookId());
        BeanUtils.copyProperties(bookInfo, books);
        return books;
    }

    @Override
    public ServiceStatus delete(long id){
        DeleteBookResponse response = client.deleteBook(id);
        return response.getServiceStatus();
    }

    @Override
    public ServiceStatus update(BookInfo bookInfo){
        UpdateBookResponse response = client.updateBook(bookInfo);
        return response.getServiceStatus();
    }

    @Override
    public Books getBookById(long id){
        GetBookByIdResponse response = client.findBookById(id);
        Books book = new Books();
        BookInfo bookInfo = response.getBookInfo();
        book.setBook_id(bookInfo.getBookId());
        BeanUtils.copyProperties(bookInfo, book);
        return book;
    }

    @Override
    public List<Books> getAllBook(){
        GetAllBooksResponse response = client.findAllBooks();
        List<BookInfo> bookInfoList = response.getBookInfo();
        List<Books> booksList = books(bookInfoList);
        return booksList;
    }

    @Override
    public List<Books> searchBooks(String author, String title){
        SearchBookResponse response;
        List<BookInfo> bookInfoList = new ArrayList<>();
        try{
            response = client.searchBooks(null, title) ;
            bookInfoList = response.getBookInfo();
        }catch (Exception e){}

        List<Books> booksList = books(bookInfoList );
        return booksList;
    }

    private List<Books> books(List<BookInfo> booksInfoList){
        List<Books> books = new ArrayList<>();
        for (int i = 0; i < booksInfoList.size(); i++) {
            Books ob = new Books();
            BeanUtils.copyProperties(booksInfoList.get(i), ob);
            ob.setBook_id(booksInfoList.get(i).getBookId());
            books.add(ob);
        }
        return books;
    }

}
