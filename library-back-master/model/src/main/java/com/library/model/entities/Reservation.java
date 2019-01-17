package com.library.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.TreeMap;

@Entity
@Table(name = "reservation")
public class Reservation {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long res_id;

    @XmlTransient
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Books book;

    @XmlTransient
    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users borrowers;

    private Integer index;

    public Long getRes_id() {
        return res_id;
    }

    public void setRes_id(Long borrow_id) {
        this.res_id = borrow_id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Users getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Users borrowers) {
        this.borrowers = borrowers;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
