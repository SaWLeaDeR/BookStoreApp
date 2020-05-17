package com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryDeleteDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryUpdateDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.BookFoundationUpdateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookFoundationUpdateServiceImpl implements BookFoundationUpdateService {

    private static final String BASE_URL = "/book";
    private static final String SLASH = "/";
    private static final String UPDATE_BOOK = "update";
    private static final String CREATE = "create";
    private static final String DELETE = "delete";
    private static final String UPDATE = "/update/category";
    private static final String DELETE_CATEGORY = "/delete/category";
    private final RestTemplate restTemplate;
    @Value("${book.service.url}")
    private String bookServiceUrl;

    public BookFoundationUpdateServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BookFoundationDto addBook(BookFoundationDto model) {
        String url = bookServiceUrl + BASE_URL + SLASH + CREATE;
        HttpEntity<BookFoundationDto> request = new HttpEntity<>(model, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, BookFoundationDto.class).getBody();
    }

    @Override
    public BookFoundationDto updateBook(Long id, BookFoundationDto book) {
        String url = bookServiceUrl + BASE_URL + SLASH + UPDATE_BOOK + SLASH + id;
        HttpEntity<BookFoundationDto> request = new HttpEntity<>(book, null);
        this.restTemplate.exchange(url, HttpMethod.PUT, request, BookFoundationDto.class).getBody();
        return book;
    }

    @Override
    public BookFoundationDto updateBooks(CategoryUpdateDto categoryUpdate) {
        String url = bookServiceUrl + BASE_URL + SLASH + UPDATE;
        HttpEntity<CategoryUpdateDto> request = new HttpEntity<>(categoryUpdate, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, BookFoundationDto.class).getBody();

    }

    @Override
    public void deleteBook(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = bookServiceUrl + BASE_URL + SLASH + DELETE + SLASH + id;
        HttpEntity<BookFoundationDto> request = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Void.class, 101);

    }

    @Override
    public void deleteBooks(CategoryDeleteDto categoryDelete) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = bookServiceUrl + BASE_URL + SLASH + DELETE_CATEGORY;
        HttpEntity<CategoryDeleteDto> request = new HttpEntity<>(categoryDelete, headers);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Void.class, 101);

    }
}
