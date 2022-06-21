package com.atrax.service.repository;

import com.atrax.service.model.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    String DELETE_REFERENCES_OF_BOOKS = "" +
            "delete from BooksWritten bw where bw.book.id = :bookId";
    @Modifying
    @Query(value = DELETE_REFERENCES_OF_BOOKS)
    void deleteReferences(@Param(value = "bookId") Long id);
}
