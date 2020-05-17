package com.foundation.category.domain.converter;

import com.foundation.category.domain.model.dto.CategoryDto;
import com.foundation.category.domain.model.entity.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public List<CategoryDto> convert(List<CategoryEntity> entities){
        List<CategoryDto> categories = new ArrayList<>();

        for (CategoryEntity entity : entities) {
            categories.add(convertSingleCategory(entity));
        }
        return categories;
    }

    public CategoryDto convertSingleCategory(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }
        CategoryDto category = new CategoryDto();
        category.setName(entity.getName());
        return category;
    }

}
