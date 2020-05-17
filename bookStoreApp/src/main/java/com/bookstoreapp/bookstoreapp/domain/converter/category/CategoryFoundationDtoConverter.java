package com.bookstoreapp.bookstoreapp.domain.converter.category;

import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.model.dto.CategoryFoundationDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

public class CategoryFoundationDtoConverter {

    public static CategoryFoundationDtoConverter INSTANCE = new CategoryFoundationDtoConverter();

    private CategoryFoundationDtoConverter(){
    }

    public static CategoryFoundationDtoConverter getInstance() {
        return INSTANCE;
    }

    public List<CategoryFoundationDto> convert(List<CategoryDto> categories){
        if (CollectionUtils.isEmpty(categories)) {
            return null;
        }
        List<CategoryFoundationDto> categoryFoundations = new ArrayList<>();

        for (CategoryDto category :  categories) {
            categoryFoundations.add(convertSingleCategory(category));
        }
        return categoryFoundations;
    }

    public CategoryFoundationDto convertSingleCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        CategoryFoundationDto categoryFoundation = new CategoryFoundationDto();
        categoryFoundation.setName(categoryDto.getCategoryName());
        return categoryFoundation;
    }

}
