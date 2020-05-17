package com.bookstore.bookstore.domain.service.impl;

import com.bookstore.bookstore.domain.converter.BookStoreDtoConverter;
import com.bookstore.bookstore.domain.model.dto.BookStoreDto;
import com.bookstore.bookstore.domain.repository.BookStoreRepository;
import com.bookstore.bookstore.domain.service.BookStoreLoadingService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BookStoreLoadingServiceImpl implements BookStoreLoadingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookStoreLoadingService.class);

    private final BookStoreRepository repository;
    private final BookStoreDtoConverter dtoConverter;

    public BookStoreLoadingServiceImpl(BookStoreRepository repository, BookStoreDtoConverter converter) {
        this.repository = repository;
        this.dtoConverter = converter;
    }

    @Override
    public List<BookStoreDto> getAllBookStores() {
        return dtoConverter.convert(repository.findAll());
    }

    @Override
    public BookStoreDto getBookStore(Long id) {
        return dtoConverter.convertSingleBook(repository.findById(id).orElse(null));
    }

    @Override
    public List<BookStoreDto> getBookStoreByName(String bookStoreName) {
        return dtoConverter.convert(repository.findByName(bookStoreName));
    }

}
