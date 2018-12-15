package com.library.service;


import com.library.model.entities.Books;
import com.library.model.entities.Employees;

import java.util.List;


public interface BooksService {
    boolean insert(Books book);
    void update(Books book);
    List<Books> getAllBooks();
    void delete(Books book);
    void deleteById(long id);
    Books getBookById(Long id);
    Books getBookByTitle(String title);
    List<Books> searchBookByTitleAndAuthor(String title, String author);
}
