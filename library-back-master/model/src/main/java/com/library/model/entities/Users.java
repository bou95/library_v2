package com.library.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long user_id;

    @Column(name="lastname")
    @Size(message="Le nom d'utilisateur doit comporter au moins 3 lettres",min=3)
    private String lastName;

    @Column(name="firstname")
    @Size(min=1)
    private String firstName;

    @Column(name="email", unique=true)
    @Size(message = "L'email de l'utilisateur doit comporter au moins une lettre",min = 1)
    @Pattern(message = "L'email n'est pas valide", regexp = "[^@]+@[^@]+")
    private String email;

    @Column(name="password")
    @Size(message = "Le mot de passe de l'utilisateur doit comporter au moins 3 lettres",min = 3)
    private String password;

    @OneToMany(mappedBy = "borrower", fetch=FetchType.EAGER)
    private List<Borrow> borrowList;

    @OneToMany(mappedBy = "borrowers", fetch=FetchType.EAGER)
    private List<Reservation> reservation;

    private boolean reminder;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }
}
