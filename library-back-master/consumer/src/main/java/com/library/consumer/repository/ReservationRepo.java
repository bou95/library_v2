package com.library.consumer.repository;

import com.library.model.entities.Books;
import com.library.model.entities.Reservation;
import com.library.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    //@Query("select b from Books b where b.book_id=:book_id")
    //Reservation findReservationWithbook_id(@Param("book_id") Long book_id);

    //@Query("select b from Users b where b.user_id=:user_id")
    //Reservation findReservationWithUser_id(@Param("user_id") Long book_id);

    Reservation findReservationByBookAndBorrowers(Books book, Users borrower);
    List<Reservation> findAllReservationsByBorrowers(Users user);
}
