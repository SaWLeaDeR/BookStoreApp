package com.bookstoreapp.bookstoreapp.domain.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = -5153206332164274751L;

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
            "name='" + categoryName + '\'' +
            '}';
    }
}
