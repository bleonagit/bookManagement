package com.atrax.service.services;

import com.atrax.service.model.dto.BookDto;
import com.atrax.service.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAll();
    void delete(Book book);
    Book save(Book book);
}
