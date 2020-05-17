package com.book.book.controller;

import com.book.book.controller.endpoint.BookEndpoint;
import com.book.book.model.dto.BookDto;
import com.book.book.model.dto.CategoryDeleteDto;
import com.book.book.model.dto.CategoryUpdateDto;
import com.book.book.service.BookUpdateService;
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
@RequestMapping("/book")
public class BookUpdateController {

    private final BookUpdateService service;

    public BookUpdateController(BookUpdateService service) {
        super();
        this.service = service;
    }

    @PostMapping(value = BookEndpoint.BOOK_CREATE)
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book) {
        return service.addBook(book);
    }


    @PutMapping(value = BookEndpoint.BOOK_UPDATE)
    public void updateBook(@PathVariable("id") Long id, @RequestBody BookDto book) {
        service.updateBook(id, book);
    }

    @PutMapping(value = BookEndpoint.BOOK_CATEGORY_UPDATE)
    public void updateBooks(@RequestBody CategoryUpdateDto categoryUpdate) {
        service.updateBooks(categoryUpdate);
    }

    @DeleteMapping(value = BookEndpoint.BOOK_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }

    @DeleteMapping(value = BookEndpoint.BOOK_CATEGORY_DELETE)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteBook(@RequestBody CategoryDeleteDto categoryDelete) {
        service.deleteBooks(categoryDelete);
    }
}
