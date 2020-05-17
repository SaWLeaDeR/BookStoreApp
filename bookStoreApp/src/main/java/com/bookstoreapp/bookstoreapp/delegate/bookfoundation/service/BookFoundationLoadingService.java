package com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import java.util.List;

public interface BookFoundationLoadingService {

    List<BookFoundationDto> getAllBooks();

    BookFoundationDto getBook(Long id);

    List<BookFoundationDto> getBookByCategory(String categoryName);

}
