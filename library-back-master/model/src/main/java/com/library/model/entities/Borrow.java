package com.library.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="borrow")
public class Borrow implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long borrow_id;

    @XmlTransient
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Books book;

    @XmlTransient
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users borrower;

    @Column(name = "term")
    private Date term;

    @Column(name = "extend")
    private Boolean extend;

    public Long getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(Long borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Users getBorrower() {
        return borrower;
    }

    public void setBorrower(Users borrower) {
        this.borrower = borrower;
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
}
