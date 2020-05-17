package com.bookstore.bookstore.domain.service;

import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import java.util.List;

public interface BookStoreLoadingService {

    List<BookStoreDto> getAllBookStores();

    BookStoreDto getBookStore(Long id);

    List<BookStoreDto> getBookStoreByName(String bookStoreName);

}
