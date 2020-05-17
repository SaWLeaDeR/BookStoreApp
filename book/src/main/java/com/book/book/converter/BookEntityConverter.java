package com.book.book.converter;

import com.book.book.model.dto.BookDto;
import com.book.book.model.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookEntityConverter {

    public BookEntity convert(BookDto book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(book.getName());
        bookEntity.setCategory(book.getCategory());
        bookEntity.setPrice(book.getPrice());
        return bookEntity;
    }

}
