package com.book.book.service.impl;

import com.book.book.converter.BookDtoConverter;
import com.book.book.model.dto.BookDto;
import com.book.book.repository.BookRepository;
import com.book.book.service.BookLoadingService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BookLoadingServiceImpl implements BookLoadingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookLoadingServiceImpl.class);

    private final BookRepository repository;
    private final BookDtoConverter dtoConverter;

    public BookLoadingServiceImpl(BookRepository repository, BookDtoConverter converter) {
        this.repository = repository;
        this.dtoConverter = converter;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return dtoConverter.convert(repository.findAll());
    }

    @Override
    public BookDto getBook(Long id) {
        return dtoConverter.convertSingleBook(repository.findById(id).orElse(null));
    }

    @Override
    public List<BookDto> getBookByCategory(String categoryName) {
        return dtoConverter.convert(repository.findByCategory(categoryName));
    }

}
