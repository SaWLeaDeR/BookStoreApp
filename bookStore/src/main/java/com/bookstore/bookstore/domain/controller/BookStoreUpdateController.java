package com.bookstore.bookstore.domain.controller;

import com.bookstore.bookstore.domain.controller.endpoint.BookStoreEndpoint;
import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import com.bookstore.bookstore.domain.service.BookStoreUpdateService;
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
@RequestMapping("/book-store")
public class BookStoreUpdateController {

    private final BookStoreUpdateService service;

    public BookStoreUpdateController(BookStoreUpdateService service) {
        super();
        this.service = service;
    }

    @PostMapping(value = BookStoreEndpoint.BOOK_STORE_CREATE)
    public ResponseEntity<BookStoreDto> addBookStore(@RequestBody BookStoreDto bookStore) {
        return service.addBookStore(bookStore);
    }

    @PutMapping(value = BookStoreEndpoint.BOOK_STORE_UPDATE)
    public void updateBookStore(@PathVariable("id") Long id, @RequestBody BookStoreDto bookStore) {
        service.updateBookStore(id, bookStore);
    }

    @DeleteMapping(value = BookStoreEndpoint.BOOK_STORE_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteBookStore(@PathVariable Long id) {
        service.deleteBookStore(id);
    }

}
