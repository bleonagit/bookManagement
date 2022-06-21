package com.atrax.service.model.dto;

import com.atrax.service.model.entity.Author;
import com.atrax.service.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private Integer pages;
    private Date dateOfPublished;
    private List<Author> authors;

    public static BookDto create(Book book){
        return new BookDto(book.getId()
                        , book.getTitle()
                        , book.getPages()
                        , book.getDateOfPublished()
                        , null
        );
    }
}
