package com.foundation.category.domain.service;

import com.foundation.category.domain.model.dto.CategoryDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    ResponseEntity<CategoryDto> addCategory(CategoryDto model);

    CategoryDto getCategory(Long id);

    CategoryDto getCategoryByName(String categoryName);

    void updateCategory(Long id, CategoryDto category);

    void deleteCategory(Long id);

    void deleteCategoryByName(String name);
}
