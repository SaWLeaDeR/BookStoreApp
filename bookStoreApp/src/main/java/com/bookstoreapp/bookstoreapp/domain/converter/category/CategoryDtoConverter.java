package com.bookstoreapp.bookstoreapp.domain.converter.category;

import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.model.dto.CategoryFoundationDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class CategoryDtoConverter {

    public static CategoryDtoConverter INSTANCE = new CategoryDtoConverter();

    private CategoryDtoConverter(){
    }

    public static CategoryDtoConverter getInstance() {
        return INSTANCE;
    }

    public List<CategoryDto> convert(List<CategoryFoundationDto> categoryFoundations){
        if (CollectionUtils.isEmpty(categoryFoundations)) {
            return null;
        }
        List<CategoryDto> categories = new ArrayList<>();

        for (CategoryFoundationDto categoryFoundation :  categoryFoundations) {
            categories.add(convertSingleCategory(categoryFoundation));
        }
        return categories;
    }

    public CategoryDto convertSingleCategory(CategoryFoundationDto categoryFoundation) {
        if (categoryFoundation == null) {
            return null;
        }
        CategoryDto category = new CategoryDto();
        category.setCategoryName(categoryFoundation.getName());
        return category;
    }

}
