package com.book.book.service.impl;

import com.book.book.converter.BookEntityConverter;
import com.book.book.model.dto.BookDto;
import com.book.book.model.dto.CategoryDeleteDto;
import com.book.book.model.dto.CategoryUpdateDto;
import com.book.book.model.entity.BookEntity;
import com.book.book.repository.BookRepository;
import com.book.book.service.BookUpdateService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class BookUpdateServiceImpl implements BookUpdateService {

    private final BookRepository repository;
    private final BookEntityConverter entityConverter;

    public BookUpdateServiceImpl(BookRepository repository, BookEntityConverter entityConverter) {
        this.repository = repository;
        this.entityConverter = entityConverter;
    }

    @Override
    public ResponseEntity<BookDto> addBook(BookDto model) {
        final BookEntity bookEntity = repository.save(entityConverter.convert(model));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookEntity.getId()).toUri();
        return ResponseEntity.created(location).body(model);
    }

    @Override
    public void updateBook(Long id, BookDto book) {
        BookEntity bookEntity = entityConverter.convert(book);
        bookEntity.setId(id);
        repository.save(bookEntity);
    }

    @Override
    public void updateBooks(CategoryUpdateDto categoryUpdateDto) {
        List<BookEntity> booksByCategory = repository.findByCategory(categoryUpdateDto.getOldCategoryName());
        booksByCategory.forEach(eachEntity-> eachEntity.setCategory(categoryUpdateDto.getNewCategoryName()));
        repository.saveAll(booksByCategory);
    }

    @Override
    public void deleteBook(Long id) {
        repository.delete(!repository.findById(id).isPresent() ? null : repository.findById(id).get());
    }

    @Override
    public void deleteBooks(CategoryDeleteDto categoryDelete) {
        repository.deleteAll(repository.findByCategory(categoryDelete.getCategoryName()));

    }

}
