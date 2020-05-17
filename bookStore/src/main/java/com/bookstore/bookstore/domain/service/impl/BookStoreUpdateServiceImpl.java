package com.bookstore.bookstore.domain.service.impl;

import com.bookstore.bookstore.domain.converter.BookStoreEntityConverter;
import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import com.bookstore.bookstore.domain.model.entity.BookStoreEntity;
import com.bookstore.bookstore.domain.repository.BookStoreRepository;
import com.bookstore.bookstore.domain.service.BookStoreUpdateService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class BookStoreUpdateServiceImpl implements BookStoreUpdateService {

    private final BookStoreRepository repository;
    private final BookStoreEntityConverter entityConverter;

    public BookStoreUpdateServiceImpl(BookStoreRepository repository, BookStoreEntityConverter entityConverter) {
        this.repository = repository;
        this.entityConverter = entityConverter;
    }

    @Override
    public ResponseEntity<BookStoreDto> addBookStore(BookStoreDto model) {
        final BookStoreEntity bookStoreEntity = repository.save(entityConverter.convert(model));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookStoreEntity.getId()).toUri();
        return ResponseEntity.created(location).body(model);
    }

    @Override
    public void updateBookStore(Long id, BookStoreDto book) {
        BookStoreEntity bookStoreEntity = entityConverter.convert(book);
        bookStoreEntity.setId(id);
        repository.save(bookStoreEntity);
    }


    @Override
    public void deleteBookStore(Long id) {
        repository.delete(!repository.findById(id).isPresent() ? null : repository.findById(id).get());
    }

}
