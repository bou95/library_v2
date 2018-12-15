package com.library.consumer.repository;

import com.library.model.entities.Books;
import com.library.model.entities.Borrow;
import com.library.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long> {
    Borrow findBorrowByBookAndAndBorrower(Books book, Users borrower);

    //@Query("update borrow p set p.extend = ")
    //void extend(boolean extend);
}
