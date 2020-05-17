package com.bookstore.bookstore.domain.service;

import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import org.springframework.http.ResponseEntity;

public interface BookStoreUpdateService {

    ResponseEntity<BookStoreDto> addBookStore(BookStoreDto model);

    void updateBookStore(Long id, BookStoreDto bookStore);

    void deleteBookStore(Long id);

}
