package com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service;

import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;
import java.util.List;

public interface BookStoreFoundationLoadingService {

    List<BookStoreFoundationDto> getAllBookStores();

    BookStoreFoundationDto getBookStore(Long id);

    List<BookStoreFoundationDto> getBookStoreByName(String bookStoreName);

}
