package com.atrax.controller.rest;

import com.atrax.service.model.dto.BookDto;
import com.atrax.service.model.entity.Book;
import com.atrax.service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAll(){
        return ResponseEntity.ok(bookService.getAll());
    }

    @PostMapping("/create")
    public void create(@RequestBody Book book){
        bookService.save(book);
    }

    @PutMapping("update")
    public void update(@RequestBody Book book){
        bookService.save(book);
    }

    @DeleteMapping
    public void delete(@RequestBody Book book){
        bookService.delete(book);
    }
}
