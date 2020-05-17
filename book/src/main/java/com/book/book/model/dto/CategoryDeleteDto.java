package com.book.book.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDeleteDto implements Serializable {

    private static final long serialVersionUID = -1437079023023842126L;

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
        CategoryDeleteDto that = (CategoryDeleteDto) o;
        return Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

    @Override
    public String toString() {
        return "CategoryDeleteDto{" +
            "categoryName='" + categoryName + '\'' +
            '}';
    }
}
