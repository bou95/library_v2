package com.library.service.impl;

import com.library.consumer.repository.BooksRepo;
import com.library.model.entities.Books;
import com.library.model.entities.Employees;
import com.library.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepo booksRepo;

    @Override
    public synchronized boolean insert (Books book) {
        Books book1 = booksRepo.findBooksByTitle(book.getTitle());
        if (book1 != null) {
            return false;
        } else {
            booksRepo.save(book);
            return true;
        }
    }

    @Override
    public void update(Books book) {
        booksRepo.save(book);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepo.findAll();
    }

    @Override
    public void delete(Books book) {
        booksRepo.delete(book);
    }

    @Override
    public void deleteById(long id) {
        booksRepo.delete(id);
    }

    @Override
    public Books getBookById(Long id){
        return booksRepo.findOne(id);
    }

    @Override
    public Books getBookByTitle(String title) {
        return booksRepo.findBooksByTitle(title);
    }

    @Override
    public List<Books> searchBookByTitleAndAuthor(String title, String author){return booksRepo.findBooksByTitleOrAuthor(title, author);}
}
