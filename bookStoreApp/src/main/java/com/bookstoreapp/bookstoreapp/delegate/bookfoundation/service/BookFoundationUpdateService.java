package com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryDeleteDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryUpdateDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface BookFoundationUpdateService {

    BookFoundationDto addBook(BookFoundationDto model);

    BookFoundationDto updateBook(Long id, BookFoundationDto book);

    BookFoundationDto updateBooks(CategoryUpdateDto categoryUpdate);

    void deleteBook(Long id);

    void deleteBooks(CategoryDeleteDto categoryDelete);
}
