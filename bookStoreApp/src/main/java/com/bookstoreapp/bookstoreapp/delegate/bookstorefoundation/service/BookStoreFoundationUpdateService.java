package com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service;

import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;

public interface BookStoreFoundationUpdateService {

    BookStoreFoundationDto addBookStore(BookStoreFoundationDto model);

    BookStoreFoundationDto updateBookStore(Long id, BookStoreFoundationDto bookStoreFoundationDto);

    void deleteBookStore(Long id);

}
