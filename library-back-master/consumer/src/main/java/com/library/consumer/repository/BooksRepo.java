package com.library.consumer.repository;


import com.library.model.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long> {
    Books findBooksByTitle(String title);

    @Query("select p from Books p where (?1 is null or p.title like ?1) and (?2 is null or p.author like ?2)")
    List<Books> findBooksByTitleOrAuthor(@Param("title")String title, @Param("author") String author);
}
