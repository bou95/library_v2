package com.library.action;

import com.library.service.BooksService;
import com.opensymphony.xwork2.ActionSupport;
import entities.Books;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksAction extends ActionSupport {

    @Autowired
    BooksService service;

    private long id;

    private String author;

    private String title;

    private String category;

    private long available;

    private List<Books> bookInfoList;



    private Books books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(long available) {
        this.available = available;
    }

    public List<Books> getBookInfoList() {
        return bookInfoList;
    }

    public void setBookInfoList(List<Books> bookInfoList) {
        this.bookInfoList = bookInfoList;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public String doCreate(){
        String Result = ActionSupport.INPUT;
        if (!StringUtils.isAnyEmpty(title, author)) {
                books = service.create(title, category, author, available);
                if (books != null) {
                    Result = ActionSupport.SUCCESS;
                }else {
                    this.addActionError("Le livre existe déja en base de donnée");
                }
        }else{
            this.addActionError("Veuillez remplir les champs obligatoires");
        }
        return Result;
    }


    public String findAllBooks(){
        bookInfoList = service.getAllBook();
        if(bookInfoList.size() < 1) {
            this.addActionMessage("Il n'y aucun livre");
            return ActionSupport.SUCCESS;
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String getBookById() {
        if (id < 1) {
            this.addActionError("Vous devez indiquer un id ");
        } else {
            books = service.getBookById(id);
            return ActionSupport.SUCCESS;
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String searchBook(){
        bookInfoList = service.searchBooks(books.getAuthor(), books.getTitle());
        if(bookInfoList.size() <1) {
            this.addActionError("Aucun livre n'a été trouvé");
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.INPUT;
    }


}
