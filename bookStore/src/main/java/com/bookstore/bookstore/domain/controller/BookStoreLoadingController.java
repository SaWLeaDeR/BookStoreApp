package com.bookstore.bookstore.domain.controller;

import com.bookstore.bookstore.domain.controller.endpoint.BookStoreEndpoint;
import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import com.bookstore.bookstore.domain.service.BookStoreLoadingService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-store")
public class BookStoreLoadingController {

    private final BookStoreLoadingService service;

    public BookStoreLoadingController(BookStoreLoadingService service) {
        super();
        this.service = service;
    }

    @GetMapping(value = BookStoreEndpoint.GET_ALL)
    public List<BookStoreDto> getAllBooks() {
        return service.getAllBookStores();
    }

    @GetMapping(value = BookStoreEndpoint.GET_BOOK_STORE)
    public BookStoreDto getBook(@PathVariable("id") Long id) {
        return service.getBookStore(id);
    }

    @GetMapping(value = BookStoreEndpoint.GET_BOOK_STORE_BY_NAME)
    public List<BookStoreDto> getBookStoreByName(@RequestParam String bookStoreName) {
        return service.getBookStoreByName(bookStoreName);
    }
}
