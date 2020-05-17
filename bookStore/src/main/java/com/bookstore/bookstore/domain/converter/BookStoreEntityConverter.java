package com.bookstore.bookstore.domain.converter;

import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import com.bookstore.bookstore.domain.model.entity.BookStoreEntity;
import org.springframework.stereotype.Component;

@Component
public class BookStoreEntityConverter {

    public BookStoreEntity convert(BookStoreDto book) {
        BookStoreEntity bookEntity = new BookStoreEntity();
        bookEntity.setName(book.getName());
        bookEntity.setAdditionalPrice(book.getAdditionalPrice());
        return bookEntity;
    }

}
