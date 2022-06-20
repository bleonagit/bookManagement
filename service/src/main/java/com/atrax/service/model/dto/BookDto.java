package com.atrax.service.model.dto;

import com.atrax.service.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;

    public static BookDto create(Book book){
        return new BookDto(book.getId(), book.getTitle());
    }
}
