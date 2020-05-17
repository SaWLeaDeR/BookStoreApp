package com.foundation.category.domain.service.impl;

import com.foundation.category.domain.converter.CategoryDtoConverter;
import com.foundation.category.domain.converter.CategoryEntityConverter;
import com.foundation.category.domain.model.dto.CategoryDto;
import com.foundation.category.domain.model.entity.CategoryEntity;
import com.foundation.category.domain.repository.CategoryRepository;
import com.foundation.category.domain.service.CategoryService;
import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository repository;
    private final CategoryDtoConverter dtoConverter;
    private final CategoryEntityConverter entityConverter;

    public CategoryServiceImpl(CategoryRepository repository, CategoryDtoConverter converter,
        CategoryEntityConverter entityConverter) {
        this.repository = repository;
        this.dtoConverter = converter;
        this.entityConverter = entityConverter;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return dtoConverter.convert(repository.findAll());
    }

    @Override
    public ResponseEntity<CategoryDto> addCategory(CategoryDto model) {
        final CategoryEntity categoryEntity = repository.save(entityConverter.convert(model));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryEntity.getId()).toUri();
        return ResponseEntity.created(location).body(model);
    }

    @Override
    public CategoryDto getCategory(Long id) {
        return dtoConverter.convertSingleCategory(repository.findById(id).orElse(null));
    }

    @Override
    public void updateCategory(Long id, CategoryDto category) {
        final CategoryEntity categoryEntity = entityConverter.convert(category);
        categoryEntity.setId(id);
        repository.save(categoryEntity);
    }

    @Override
    public void deleteCategory(Long id) {
        repository.delete(!repository.findById(id).isPresent() ? null : repository.findById(id).get());
    }

    @Override
    public void deleteCategoryByName(String name) {
        final CategoryEntity byName = repository.findByName(name);
        if (byName == null) {
            return;
        }
        repository.delete(byName);
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName) {
        return dtoConverter.convertSingleCategory(repository.findByName(categoryName));
    }
}
