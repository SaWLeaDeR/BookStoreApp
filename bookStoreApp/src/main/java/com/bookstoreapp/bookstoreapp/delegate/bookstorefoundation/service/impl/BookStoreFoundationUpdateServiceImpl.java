package com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service.BookStoreFoundationUpdateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookStoreFoundationUpdateServiceImpl implements BookStoreFoundationUpdateService {

    private static final String BASE_URL = "/book-store";
    private static final String SLASH = "/";
    private static final String CREATE = "create";
    private static final String DELETE = "delete";
    private static final String UPDATE = "/update";

    private final RestTemplate restTemplate;
    @Value("${book.store.service.url}")
    private String bookServiceUrl;

    public BookStoreFoundationUpdateServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BookStoreFoundationDto addBookStore(BookStoreFoundationDto model) {
        String url = bookServiceUrl + BASE_URL + SLASH + CREATE;
        HttpEntity<BookStoreFoundationDto> request = new HttpEntity<>(model, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, BookStoreFoundationDto.class).getBody();
    }

    @Override
    public BookStoreFoundationDto updateBookStore(Long id, BookStoreFoundationDto bookStoreFoundationDto) {
        String url = bookServiceUrl + BASE_URL + UPDATE +SLASH + id;
        HttpEntity<BookStoreFoundationDto> request = new HttpEntity<>(bookStoreFoundationDto, null);
        this.restTemplate.exchange(url, HttpMethod.PUT, request, BookStoreFoundationDto.class).getBody();
        return bookStoreFoundationDto;
    }

    @Override
    public void deleteBookStore(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = bookServiceUrl + BASE_URL + SLASH + DELETE + SLASH + id;
        HttpEntity<BookStoreFoundationDto> request = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Void.class, 101);
    }
}
