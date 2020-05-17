package com.bookstoreapp.bookstoreapp.domain.service;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryDeleteDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryUpdateDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;

public interface BookStoreAggregationUpdateService {

    BookDto addBook(BookDto book);

    BookDto updateBook(Long id, BookDto book);

    BookDto updateBooks(CategoryUpdateDto categoryUpdate);

    void deleteBook(Long id);

    void deleteBooks(CategoryDeleteDto categoryDelete);

    CategoryDto addCategory(CategoryDto category);

    CategoryDto updateCategory(Long id, CategoryDto category);

    void deleteCategory(Long id);

    BookStoreDto addBookStore(BookStoreDto book);

    BookStoreDto updateBookStore(Long id, BookStoreDto book);

    void deleteBookStore(Long id);
}
