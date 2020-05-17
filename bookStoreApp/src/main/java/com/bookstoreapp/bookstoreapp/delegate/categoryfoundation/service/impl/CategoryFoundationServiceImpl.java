package com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.model.dto.CategoryFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.service.CategoryFoundationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryFoundationServiceImpl implements CategoryFoundationService {

    private static final String BASE_URL = "/category";
    private static final String NAME = "/name";
    private static final String SLASH = "/";
    private static final String DELETE = "delete";
    private final RestTemplate restTemplate;
    @Value("${category.service.url}")
    private String categoryServiceUrl;

    public CategoryFoundationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<CategoryFoundationDto> getAllCategories() {
        String url = categoryServiceUrl + BASE_URL;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<CategoryFoundationDto>>() {
        }).getBody();
    }

    @Override
    public CategoryFoundationDto addCategory(CategoryFoundationDto category) {
        String url = categoryServiceUrl + BASE_URL;
        HttpEntity<CategoryFoundationDto> request = new HttpEntity<>(category, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, CategoryFoundationDto.class).getBody();
    }

    @Override
    public CategoryFoundationDto getCategory(Long id) {
        String url = categoryServiceUrl + BASE_URL + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, CategoryFoundationDto.class).getBody();
    }

    @Override
    public CategoryFoundationDto getCategoryByName(String categoryName) {
        String url = categoryServiceUrl + BASE_URL + SLASH + NAME + "?categoryName=" + categoryName;
        HttpEntity<CategoryFoundationDto> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, CategoryFoundationDto.class).getBody();
    }

    @Override
    public CategoryFoundationDto updateCategory(Long id, CategoryFoundationDto category) {
        String url = categoryServiceUrl + BASE_URL + SLASH + id;
        HttpEntity<CategoryFoundationDto> request = new HttpEntity<>(category, null);
        this.restTemplate.exchange(url, HttpMethod.PUT, request, CategoryFoundationDto.class).getBody();
        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = categoryServiceUrl + BASE_URL + SLASH + id;
        HttpEntity<CategoryFoundationDto> request = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Void.class, 101);
    }

    @Override
    public void deleteCategoryByName(String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = categoryServiceUrl + BASE_URL + SLASH + DELETE + SLASH + name;
        HttpEntity<CategoryFoundationDto> request = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Void.class, 101);
    }
}
