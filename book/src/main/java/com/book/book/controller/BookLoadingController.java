package com.book.book.controller;

import com.book.book.controller.endpoint.BookEndpoint;
import com.book.book.model.dto.BookDto;
import com.book.book.service.BookLoadingService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookLoadingController {

    private final BookLoadingService service;

    public BookLoadingController(BookLoadingService service) {
        super();
        this.service = service;
    }

    @GetMapping(value = BookEndpoint.BOOKS)
    public List<BookDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping(value = BookEndpoint.BOOK)
    public BookDto getBook(@PathVariable("id") Long id) {
        return service.getBook(id);
    }

    @GetMapping(value = BookEndpoint.BOOK_CATEGORY)
    public List<BookDto> getBooksByCategory(@RequestParam String categoryName) {
        return service.getBookByCategory(categoryName);
    }
}
