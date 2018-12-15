package com.library.service;

import com.library.wsdl.books.BookInfo;
import com.library.wsdl.books.ServiceStatus;
import entities.Books;

import java.util.List;

public interface BooksService {
    Books create(String title, String category, String author, long available);

    ServiceStatus delete(long id);

    ServiceStatus update(BookInfo bookInfo);

    Books getBookById(long id);

    List<Books> getAllBook();

    List<Books> searchBooks(String author, String title);
}
