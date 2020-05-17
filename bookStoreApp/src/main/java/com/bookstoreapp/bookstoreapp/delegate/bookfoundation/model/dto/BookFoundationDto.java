package com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BookFoundationDto implements Serializable {

    private static final long serialVersionUID = 2880629704054836727L;

    private String name;

    private String category;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookFoundationDto that = (BookFoundationDto) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(category, that.category) &&
            Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }

    @Override
    public String toString() {
        return "BookFoundationDto{" +
            "name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            '}';
    }
}
