package com.book.book.converter;

import com.book.book.model.dto.BookDto;
import com.book.book.model.entity.BookEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    public List<BookDto> convert(List<BookEntity> entities) {
        List<BookDto> books = new ArrayList<>();

        for (BookEntity entity : entities) {
            books.add(convertSingleBook(entity));
        }
        return books;
    }

    public BookDto convertSingleBook(BookEntity entity) {
        if (entity == null){
            return null;
        }

        BookDto book = new BookDto();
        book.setName(entity.getName());
        book.setCategory(entity.getCategory());
        book.setPrice(entity.getPrice());
        return book;
    }

}
