package com.library.model.entities;

import javax.persistence.*;
import java.util.TreeMap;

@Entity
@Table(name = "reservation")
public class Reservation {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long res_id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Books assigned_book;

    private TreeMap<Long, Users> borrowers;

    public Long getRes_id() {
        return res_id;
    }

    public void setRes_id(Long borrow_id) {
        this.res_id = borrow_id;
    }

    public Books getAssigned_book() {
        return assigned_book;
    }

    public void setAssigned_book(Books assigned_book) {
        this.assigned_book = assigned_book;
    }

    public TreeMap<Long, Users> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(TreeMap<Long, Users> borrowers) {
        this.borrowers = borrowers;
    }
}
