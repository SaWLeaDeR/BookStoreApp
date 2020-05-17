package com.bookstoreapp.bookstoreapp.domain.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class BookStoreDto implements Serializable {

    private static final long serialVersionUID = -4728980589917483729L;

    private String bookStoreName;

    private List<BookDto> books;
    private BigDecimal additionalPrice;

    public String getBookStoreName() {
        return bookStoreName;
    }

    public void setBookStoreName(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookStoreDto that = (BookStoreDto) o;
        return Objects.equals(bookStoreName, that.bookStoreName) &&
            Objects.equals(books, that.books) &&
            Objects.equals(additionalPrice, that.additionalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookStoreName, books, additionalPrice);
    }

    @Override
    public String toString() {
        return "BookStoreDto{" +
            "bookStoreName='" + bookStoreName + '\'' +
            ", books=" + books +
            ", additionalPrice=" + additionalPrice +
            '}';
    }
}
