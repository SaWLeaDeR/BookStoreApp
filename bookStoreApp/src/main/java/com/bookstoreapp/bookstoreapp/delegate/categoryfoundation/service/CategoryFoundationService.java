package com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.service;

import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.model.dto.CategoryFoundationDto;
import java.util.List;

public interface CategoryFoundationService {

    List<CategoryFoundationDto> getAllCategories();

    CategoryFoundationDto addCategory(CategoryFoundationDto category);

    CategoryFoundationDto getCategory(Long id);

    CategoryFoundationDto getCategoryByName(String categoryName);

    CategoryFoundationDto updateCategory(Long id, CategoryFoundationDto category);

    void deleteCategory(Long id);

    void deleteCategoryByName(String name);

}
