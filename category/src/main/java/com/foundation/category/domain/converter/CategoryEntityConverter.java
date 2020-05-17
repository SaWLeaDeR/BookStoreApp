package com.foundation.category.domain.converter;

import com.foundation.category.domain.model.dto.CategoryDto;
import com.foundation.category.domain.model.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityConverter {

    public CategoryEntity convert(CategoryDto category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        return categoryEntity;
    }

}
