package com.atrax.service.model.entity;

import javax.persistence.*;

@Entity
public class BooksWritten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
