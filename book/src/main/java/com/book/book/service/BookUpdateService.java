package com.book.book.service;

import com.book.book.model.dto.BookDto;
import com.book.book.model.dto.CategoryDeleteDto;
import com.book.book.model.dto.CategoryUpdateDto;
import org.springframework.http.ResponseEntity;

public interface BookUpdateService {

    ResponseEntity<BookDto> addBook(BookDto model);

    void updateBook(Long id, BookDto book);

    void updateBooks(CategoryUpdateDto categoryUpdate);

    void deleteBook(Long id);

    void deleteBooks(CategoryDeleteDto categoryDelete);

}
