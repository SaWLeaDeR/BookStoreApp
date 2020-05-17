package com.bookstoreapp.bookstoreapp.domain.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BookDto implements Serializable {

    private static final long serialVersionUID = -5632937076706259165L;

    private String bookName;
    private String categoryName;
    private BigDecimal price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        return Objects.equals(bookName, bookDto.bookName) &&
            Objects.equals(categoryName, bookDto.categoryName) &&
            Objects.equals(price, bookDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, categoryName, price);
    }

    @Override
    public String toString() {
        return "BookDto{" +
            "bookName='" + bookName + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", price=" + price +
            '}';
    }
}
