package com.bookstoreapp.bookstoreapp.domain.controller;

import com.bookstoreapp.bookstoreapp.domain.controller.endpoint.BookStoreAppLoadingEndpoint;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import com.bookstoreapp.bookstoreapp.domain.service.BookStoreAggregationLoadingService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookStoreAggregationLoadingController {

    private final BookStoreAggregationLoadingService service;

    public BookStoreAggregationLoadingController(BookStoreAggregationLoadingService service) {
        super();
        this.service = service;
    }

    @GetMapping
    public List<BookStoreDto> getAll() {
        return service.getAll();
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_ALL_BOOKS)
    public List<BookDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_ALL_CATEGORIES)
    public List<CategoryDto> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_ALL_BOOK_STORES)
    public List<BookStoreDto> getAllBookStores() {
        return service.getAllBookStores();
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_BOOK)
    public BookDto getBook(@PathVariable("id") Long id) {
        return service.getBook(id);
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_CATEGORY)
    public CategoryDto getCategory(@PathVariable("id") Long id) {
        return service.getCategory(id);
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_CATEGORY_BY_NAME)
    public CategoryDto getCategoryByName(@RequestParam String categoryName) {
        return service.getCategoryByName(categoryName);
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_BOOK_STORE)
    public BookStoreDto getBookStore(@PathVariable("id") Long id) {
        return service.getBookStore(id);
    }

    @GetMapping(value = BookStoreAppLoadingEndpoint.GET_ALL_BOOKS_BY_CATEGORY)
    public List<BookDto> getBookByCategoryName(@RequestParam String categoryName) {
        return service.getBooksByCategoryName(categoryName);
    }

}
