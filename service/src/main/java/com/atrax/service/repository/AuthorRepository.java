package com.atrax.service.repository;

import com.atrax.service.model.entity.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    String FIND_AUTHOR_BY_BOOK_ID = "" +
            "select a from Author a " +
            "inner join BooksWritten bw " +
            "on a.id = bw.author.id " +
            "where bw.book.id = :bookId";

    @Query(value = FIND_AUTHOR_BY_BOOK_ID)
    List<Author> findByBookId(@Param("bookId") Long bookId);
}
