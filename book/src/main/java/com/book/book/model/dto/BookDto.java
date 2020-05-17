package com.book.book.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BookDto implements Serializable {

    private static final long serialVersionUID = -4953759199685393093L;

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
        BookDto bookDto = (BookDto) o;
        return Objects.equals(name, bookDto.name) &&
            Objects.equals(category, bookDto.category) &&
            Objects.equals(price, bookDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }

    @Override
    public String toString() {
        return "BookDto{" +
            "name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            '}';
    }
}
