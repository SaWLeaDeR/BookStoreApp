package com.book.book.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryUpdateDto implements Serializable {

    private static final long serialVersionUID = -1248187845107919959L;
    private String oldCategoryName;
    private String newCategoryName;

    public String getOldCategoryName() {
        return oldCategoryName;
    }

    public void setOldCategoryName(String oldCategoryName) {
        this.oldCategoryName = oldCategoryName;
    }

    public String getNewCategoryName() {
        return newCategoryName;
    }

    public void setNewCategoryName(String newCategoryName) {
        this.newCategoryName = newCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryUpdateDto that = (CategoryUpdateDto) o;
        return Objects.equals(oldCategoryName, that.oldCategoryName) &&
            Objects.equals(newCategoryName, that.newCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldCategoryName, newCategoryName);
    }

    @Override
    public String toString() {
        return "CategoryUpdateDto{" +
            "oldCategoryName='" + oldCategoryName + '\'' +
            ", newCategoryName='" + newCategoryName + '\'' +
            '}';
    }
}
