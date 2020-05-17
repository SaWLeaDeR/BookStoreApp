package com.bookstoreapp.bookstoreapp.domain.service;

import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import java.util.List;

public interface BookStoreAggregationLoadingService {

    List<BookStoreDto> getAll();

    List<BookDto> getAllBooks();

    List<CategoryDto> getAllCategories();

    List<BookStoreDto> getAllBookStores();

    BookDto getBook(Long id);

    CategoryDto getCategory(Long id);
    CategoryDto getCategoryByName(String categoryName);

    BookStoreDto getBookStore(Long id);

    List<BookDto> getBooksByCategoryName(String categoryName);
}
