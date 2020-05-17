package com.bookstoreapp.bookstoreapp.domain.controller;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryDeleteDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryUpdateDto;
import com.bookstoreapp.bookstoreapp.domain.controller.endpoint.BookStoreAppUpdateEndpoint;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import com.bookstoreapp.bookstoreapp.domain.service.BookStoreAggregationUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookStoreAggregationUpdateController {

    private final BookStoreAggregationUpdateService service;

    public BookStoreAggregationUpdateController(BookStoreAggregationUpdateService service) {
        this.service = service;
    }

    @PostMapping(value = BookStoreAppUpdateEndpoint.BOOK_CREATE)
    public BookDto addBook(@RequestBody BookDto book) {
        return service.addBook(book);
    }

    @PutMapping(value = BookStoreAppUpdateEndpoint.BOOK_UPDATE)
    public BookDto updateBook(@PathVariable("id") Long id, @RequestBody BookDto book) {
        return service.updateBook(id, book);
    }

    @PutMapping(value = BookStoreAppUpdateEndpoint.BOOKS_UPDATE)
    public void updateBooks(@RequestBody CategoryUpdateDto categoryUpdate) {
        service.updateBooks(categoryUpdate);
    }

    @DeleteMapping(value = BookStoreAppUpdateEndpoint.BOOK_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }

    @DeleteMapping(value = BookStoreAppUpdateEndpoint.BOOKS_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteBooks(@RequestBody CategoryDeleteDto categoryDelete) {
        service.deleteBooks(categoryDelete);
    }

    @PostMapping(value = BookStoreAppUpdateEndpoint.CATEGORY_CREATE)
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
        return service.addCategory(categoryDto);
    }

    @PutMapping(value = BookStoreAppUpdateEndpoint.CATEGORY_UPDATE)
    public CategoryDto updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping(value = BookStoreAppUpdateEndpoint.CATEGORY_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @PostMapping(value = BookStoreAppUpdateEndpoint.BOOK_STORE_CREATE)
    public BookStoreDto addBookStore(@RequestBody BookStoreDto bookStore) {
        return service.addBookStore(bookStore);
    }

    @PutMapping(value = BookStoreAppUpdateEndpoint.BOOK_STORE_UPDATE)
    public BookStoreDto updateBookStore(@PathVariable("id") Long id, @RequestBody BookStoreDto bookStore) {
        return service.updateBookStore(id, bookStore);
    }

    @DeleteMapping(value = BookStoreAppUpdateEndpoint.BOOK_STORE_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteBookStore(@PathVariable Long id) {
        service.deleteBookStore(id);
    }

}
