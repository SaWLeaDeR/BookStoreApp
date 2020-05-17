package com.bookstore.bookstore.domain.converter;

import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import com.bookstore.bookstore.domain.model.entity.BookStoreEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BookStoreDtoConverter {

    public List<BookStoreDto> convert(List<BookStoreEntity> entities) {
        List<BookStoreDto> books = new ArrayList<>();

        for (BookStoreEntity entity : entities) {
            books.add(convertSingleBook(entity));
        }
        return books;
    }

    public BookStoreDto convertSingleBook(BookStoreEntity entity) {
        if (entity == null){
            return null;
        }

        BookStoreDto book = new BookStoreDto();
        book.setName(entity.getName());
        book.setAdditionalPrice(entity.getAdditionalPrice());
        return book;
    }

}
