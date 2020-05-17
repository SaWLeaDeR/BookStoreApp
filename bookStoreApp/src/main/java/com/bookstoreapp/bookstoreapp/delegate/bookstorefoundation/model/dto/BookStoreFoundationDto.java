package com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BookStoreFoundationDto implements Serializable {

    private static final long serialVersionUID = -2138898241096167767L;

    private String name;

    private BigDecimal additionalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        BookStoreFoundationDto that = (BookStoreFoundationDto) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(additionalPrice, that.additionalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, additionalPrice);
    }

    @Override
    public String toString() {
        return "BookStoreFoundationDto{" +
            "name='" + name + '\'' +
            ", additionalPrice=" + additionalPrice +
            '}';
    }
}
