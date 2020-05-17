package com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.BookFoundationLoadingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookFoundationLoadingServiceImpl implements BookFoundationLoadingService {

    private static final String BASE_URL = "/book";
    private static final String SLASH = "/";
    private static final String LIST = "list";
    private static final String CATEGORY = "category";
    private final RestTemplate restTemplate;
    @Value("${book.service.url}")
    private String bookServiceUrl;

    public BookFoundationLoadingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<BookFoundationDto> getAllBooks() {
        String url = bookServiceUrl + BASE_URL + SLASH + LIST;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<BookFoundationDto>>() {
        }).getBody();
    }

    @Override
    public BookFoundationDto getBook(Long id) {
        String url = bookServiceUrl + BASE_URL + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, BookFoundationDto.class).getBody();
    }

    @Override
    public List<BookFoundationDto> getBookByCategory(String categoryName) {
        String url = bookServiceUrl + BASE_URL + SLASH + CATEGORY + "?categoryName=" + categoryName;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<BookFoundationDto>>() {
        }).getBody();
    }


}
