package com.foundation.category.domain.controller;

import com.foundation.category.domain.model.dto.CategoryDto;
import com.foundation.category.domain.service.CategoryService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        super();
        this.service = service;
    }

    @GetMapping
    public List<CategoryDto> getCategory() {
        return service.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto category) {
        return service.addCategory(category);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable("id") Long id) {
        return service.getCategory(id);
    }

    @GetMapping("/name")
    public CategoryDto getCategoryByName(@RequestParam String categoryName) {
        return service.getCategoryByName(categoryName);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto category) {
        service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @DeleteMapping("/delete/{name}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteCategoryByName(@PathVariable String name) {
        service.deleteCategoryByName(name);
    }
}
