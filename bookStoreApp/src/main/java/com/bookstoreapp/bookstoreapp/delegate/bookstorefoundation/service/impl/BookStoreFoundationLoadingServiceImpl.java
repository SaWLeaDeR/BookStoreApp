package com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service.BookStoreFoundationLoadingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookStoreFoundationLoadingServiceImpl implements BookStoreFoundationLoadingService {

    private static final String BASE_URL = "/book-store";
    private static final String SLASH = "/";
    private static final String LIST = "list";
    private static final String NAME = "book-store-name";
    private final RestTemplate restTemplate;
    @Value("${book.store.service.url}")
    private String bookStoreServiceUrl;

    public BookStoreFoundationLoadingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<BookStoreFoundationDto> getAllBookStores() {
        String url = bookStoreServiceUrl + BASE_URL + SLASH + LIST;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<BookStoreFoundationDto>>(){
        }).getBody();
    }

    @Override
    public BookStoreFoundationDto getBookStore(Long id) {
        String url = bookStoreServiceUrl + BASE_URL + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, BookStoreFoundationDto.class).getBody();
    }

    @Override
    public List<BookStoreFoundationDto> getBookStoreByName(String bookStoreName) {
        String url = bookStoreServiceUrl + BASE_URL + SLASH + NAME + "?bookStoreName=" + bookStoreName;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<BookStoreFoundationDto>>() {
        }).getBody();
    }
}
