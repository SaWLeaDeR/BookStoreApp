package com.book.book.service;

import com.book.book.model.dto.BookDto;
import java.util.List;

public interface BookLoadingService {

    List<BookDto> getAllBooks();

    BookDto getBook(Long id);

    List<BookDto> getBookByCategory(String categoryName);

}
