package com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryFoundationDto implements Serializable {

    private static final long serialVersionUID = 1086874726294945248L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryFoundationDto that = (CategoryFoundationDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CategoryFoundationDto{" +
            "name='" + name + '\'' +
            '}';
    }
}
