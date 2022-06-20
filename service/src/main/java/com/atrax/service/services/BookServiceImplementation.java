package com.atrax.service.services;

import com.atrax.service.model.dto.BookDto;
import com.atrax.service.model.entity.Book;
import com.atrax.service.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<BookDto> getAll() {
        List<BookDto> list = new ArrayList<>();
        bookRepository.findAll().forEach(book -> {
            list.add(Optional.ofNullable(book)
                    .map(BookDto::create).get());
        });
        return list;
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

}
